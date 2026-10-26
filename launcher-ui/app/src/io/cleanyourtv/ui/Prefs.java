package io.cleanyourtv.ui;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Settings changed on the TV itself (CleanYourTV UI > Settings). config.properties only gives the first
 * values; anything the user changes here wins. Read from the :home process (home screen, screensaver, settings).
 */
final class Prefs {
    private Prefs() {}

    /** Bumped by every change: screens compare it to know when to redraw. */
    static volatile int version;

    private static Context app;

    static void init(Context c) {
        app = c.getApplicationContext();
        Ui.applyLanguage();   // the language picked on the TV, now that it can be read
        if (!sp().contains("theme") || "auto".equals(sp().getString("theme", null))) {
            sp().edit().putString("theme", "dark").apply();
        }
    }

    private static SharedPreferences sp() {
        return app.getSharedPreferences("settings", Context.MODE_PRIVATE);
    }

    private static void put(String key, String value) {
        sp().edit().putString(key, value).apply();
        version++;
    }

    private static void put(String key, boolean value) {
        sp().edit().putBoolean(key, value).apply();
        version++;
    }

    // MARK: - Language and units

    /** "auto", "tr", "pt", "en", "es", "de" or "ru". */
    static String language() {
        String v = app == null ? Config.LANGUAGE : sp().getString("language", Config.LANGUAGE);
        v = v.trim().toLowerCase(Locale.ROOT);
        return v.startsWith("tr") ? "tr" : v.startsWith("ru") ? "ru" : v.startsWith("pt") ? "pt" : v.startsWith("es") ? "es"
                : v.startsWith("de") ? "de" : v.startsWith("en") ? "en" : "auto";
    }

    static void setLanguage(String v) { put("language", v); Ui.applyLanguage(); }

    /** "auto", "C" or "F". */
    static String temperature() {
        String v = sp().getString("temperature", Config.TEMPERATURE).trim().toUpperCase(Locale.ROOT);
        return v.startsWith("F") ? "F" : v.startsWith("C") ? "C" : "auto";
    }

    static void setTemperature(String v) { put("temperature", v); }

    /** "dark" (default, always dark unless user explicitly chooses light). */
    static String theme() {
        String v = sp().getString("theme", "dark");
        if (v == null || v.trim().isEmpty() || "auto".equals(v)) return "dark";
        return v.equals("light") ? "light" : "dark";
    }

    static void setTheme(String v) { put("theme", v); }

    // MARK: - City

    static String city() { return sp().getString("city", Config.CITY).trim(); }
    static String latitude() { return sp().getString("latitude", Config.LATITUDE); }
    static String longitude() { return sp().getString("longitude", Config.LONGITUDE); }

    static void setCity(String name, String latitude, String longitude) {
        sp().edit().putString("city", name).putString("latitude", latitude).putString("longitude", longitude).apply();
        version++;
    }

    // MARK: - Sounds and clock

    static boolean sounds() { return sp().getBoolean("sounds", false); }
    static void setSounds(boolean on) { put("sounds", on); }

    /** "auto", "24h" or "12h". */
    static String clockFormat() { return sp().getString("clock_format", "auto"); }
    static void setClockFormat(String v) { put("clock_format", v); }

    static String userEmail() {
        String v = sp().getString("user_email", null);
        if (v != null && !v.trim().isEmpty()) return v.trim();
        if (app != null) {
            try {
                android.accounts.AccountManager am = android.accounts.AccountManager.get(app);
                android.accounts.Account[] accounts = am.getAccountsByType("com.google");
                if (accounts != null && accounts.length > 0 && accounts[0].name != null) {
                    v = accounts[0].name.trim();
                    sp().edit().putString("user_email", v).apply();
                    return v;
                }
            } catch (Exception ignored) {}
        }
        return null;
    }

    static void setUserEmail(String email) { put("user_email", email); }

    static String userName() {
        String custom = sp().getString("user_name", null);
        if (custom != null && !custom.trim().isEmpty()) return custom.trim();
        return null;
    }

    static void setUserName(String name) { put("user_name", name); }

    // MARK: - Widgets and coins

    static boolean weather() { return sp().getBoolean("weather", true); }
    static void setWeather(boolean on) { put("weather", on); }

    static boolean quotes() { return sp().getBoolean("quotes", false); }
    static void setQuotes(boolean on) { put("quotes", on); }

    static boolean coin(int i) { return sp().getBoolean("coin" + i, true); }
    static void setCoin(int i, boolean on) { put("coin" + i, on); }

    // MARK: - Shelf

    /** Packages on the home shelf, in order; null until the user edits it (then the built-in list applies). */
    static List<String> shelf() {
        String v = sp().getString("shelf", null);
        if (v == null) return null;
        List<String> out = new ArrayList<>();
        for (String p : v.split(",")) if (!p.isEmpty()) out.add(p);
        return out;
    }

    static void setShelf(List<String> packages) {
        StringBuilder sb = new StringBuilder();
        for (String p : packages) sb.append(sb.length() == 0 ? "" : ",").append(p);
        put("shelf", sb.toString());
    }

    // MARK: - Hidden apps

    /** Packages kept out of All Apps (config.json "hidden_apps"), on top of HomeApps' own list. */
    static java.util.Set<String> hidden() {
        return new java.util.HashSet<>(java.util.Arrays.asList(sp().getString("hidden", "").split(",")));
    }

    static void setHidden(List<String> packages) { put("hidden", String.join(",", packages)); }

    // MARK: - Custom tiles

    /** "logo source|#RRGGBB" for a styled shelf tile, or "" (CustomTiles). */
    static String tile(String pkg) { return sp().getString("tile." + pkg, ""); }

    static void setTile(String pkg, String logo, String color) {
        boolean none = (logo == null || logo.trim().isEmpty()) && (color == null || color.trim().isEmpty());
        put("tile." + pkg, none ? "" : (logo == null ? "" : logo.trim()) + "|" + (color == null ? "" : color.trim()));
    }

    // MARK: - Recommendations

    /** What a TMDB watch provider opens: a package, "off", or "" (the built-in match). */
    static String provider(String id) { return sp().getString("provider." + id, ""); }
    static void setProvider(String id, String value) { put("provider." + id, value == null ? "" : value); }

    /** Changes whenever a service's app changes, so the picks are fetched again. */
    static int providersStamp() {
        int h = 0;
        for (java.util.Map.Entry<String, ?> e : sp().getAll().entrySet()) {
            if (e.getKey().startsWith("provider.")) h = h * 31 + (e.getKey() + "=" + e.getValue()).hashCode();
        }
        return h;
    }

    /** Picks from every provider in the region, not only the ones with an app on the TV. */
    static boolean showAllProviders() { return sp().getBoolean("showAllProviders", false); }
    static void setShowAllProviders(boolean on) { put("showAllProviders", on); }

    // MARK: - Remote buttons

    // The key service runs in its own small process (:keys), so that a busy home screen can never delay the TV's keys.
    // SharedPreferences are not shared between processes, so the button choices live in a tiny file both read.
    // A line is "<button>=<action>": the button is "s<scancode>" or "k<keycode>"; RemoteKeys lists the actions.
    private static File keysFile() {
        return new File(app.getFilesDir(), "remote-keys.txt");
    }

    private static final java.util.Map<String, String> buttons = new java.util.HashMap<>();
    private static long keysStamp = Long.MIN_VALUE;

    private static boolean writeKeys(String text) {
        File tmp = new File(app.getFilesDir(), "remote-keys." + android.os.Process.myPid() + ".tmp");
        try (FileOutputStream out = new FileOutputStream(tmp)) {
            out.write(text.getBytes(StandardCharsets.UTF_8));
            out.getFD().sync();
        } catch (IOException e) {
            //noinspection ResultOfMethodCallIgnored
            tmp.delete();
            return false;
        }
        return tmp.renameTo(keysFile());
    }

    /** Every choice made for a button, re-read only when the file changed. */
    static java.util.Map<String, String> buttons() {
        synchronized (buttons) {
            File f = keysFile();
            long stamp = f.lastModified() * 31 + f.length();
            if (stamp != keysStamp) {
                keysStamp = stamp;
                buttons.clear();
                if (f.isFile()) {
                    try (BufferedReader r = new BufferedReader(new FileReader(f))) {
                        String line;
                        while ((line = r.readLine()) != null) {
                            int eq = line.indexOf('=');
                            if (eq > 1) buttons.put(line.substring(0, eq), line.substring(eq + 1));
                        }
                    } catch (IOException ignored) {
                    }
                }
            }
            return new java.util.HashMap<>(buttons);
        }
    }

    /** The action picked for a button, or null when the person never picked one (remote.json's default applies). */
    static String button(String id) { return buttons().get(id); }

    static void setButton(String id, String action) {
        java.util.Map<String, String> all = buttons();
        if (action == null) all.remove(id); else all.put(id, action);
        StringBuilder sb = new StringBuilder();
        for (java.util.Map.Entry<String, String> e : all.entrySet()) sb.append(e.getKey()).append('=').append(e.getValue()).append('\n');
        if (writeKeys(sb.toString())) version++;
    }
}
