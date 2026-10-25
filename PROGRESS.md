# Progress — CleanYourTV-UI (Philips 58PUS8507/12)

## Current state
- `CleanYourTV-UI` (`io.cleanyourtv.ui`) installed and set as default launcher (`cmd package set-home-activity io.cleanyourtv.ui/.HomeActivity`) without disabling any factory/system packages.
- TMDB v3 API key configured (`tr-TR` language, `TR` watch region).
- Top-right corner now has 4 buttons: Explore (`Keşfet`), HDMI Inputs (`HDMI Girişleri`), Wi-Fi (`Wi-Fi ve Ağ`), and Settings (`Ayarlar`).
- All TMDB genres, weather conditions, and Explore/Detail UI labels localized to Turkish; recommendations prioritize localized Turkish titles.

## Decisions
- 2026-10-25: Fixed `Prefs.language()` to recognize `"tr"`, fixed `Recs.fetchDetails()` to map TMDB genres through `GENRES_TR`, prioritized `p.localized` titles on the home screen, and bumped `Recs.CACHE_VERSION = 6`.
- 2026-10-25: Added `HomeApps.WIFI` (`wifi.png` symbol) to the top-right bar and All Apps drawer shortcuts, opening `com.android.tv.settings/.connectivity.NetworkActivity` with `Settings.ACTION_WIFI_SETTINGS` fallback.

## Open issues / Next
- None.

## Log
- 2026-10-25: Added top-right Wi-Fi icon and full Turkish TMDB/UI localization — `HomeView.java`, `HomeApps.java`, `Recs.java`, `HomeData.java`, `Prefs.java`, `Turkish.java`, `ExploreActivity.java`, `wifi.png` — verified on TV (`home_wifi_tr_loaded.png`).
