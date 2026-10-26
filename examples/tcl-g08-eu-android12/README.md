# TCL Smart TV Pro (G08, Android TV 12), European firmware

TCL `G08` set, model "Smart TV Pro", product `G08_4K_GB`, firmware `STT2.221228.001 AS34`, Android 12.
The same G08 board family as the C755, QM6K, 85RM7L and US lists, on the older EU Android 12 build — the
US list matches only partially: this build has no Samba-ACR ttvs payload, no `AirplayAPK`, no
hotelmenu/channelplus/e-sticker/TV+/usercenter preloads, and no Android 14 ad services.

| File | What it is |
|---|---|
| `debloat.txt` | The 32 packages: the 24 disabled on the first set and eight from the third unit, grouped and commented |

**How much testing is behind it:** one set, 21 October 2026. All 24 packages are disabled on the live set
(`pm list packages -d` verified) and the TV boots, plays Live TV/HDMI, and the remote's Source key opens
the QuickPanel (verified via log injection `input keyevent 178` → `QuickPanelDialog`). Applied by hand
with `pm disable-user --user 0`, not via `tools/disable.sh`.

**What bit us:** an earlier pass using the US G08 list disabled `com.tcl.suspension`, `com.tcl.interactive`
and `com.tcl.ttvs`, which killed the remote's Source key (the QuickPanel lives in `com.tcl.suspension`,
started by `TclShortCutKeyManager` as `com.tcl.suspension/.DismissService`) and made
`vendor.tcl.tvinput.extend-service` spam null-binder + `com.tcl.tbrowser` NPEs at ~10 Hz. All three were
re-enabled and are listed in `debloat.txt` as commented DO-NOT-DISABLE lines with the failure signature.

**Not done here:** no custom launcher installed; stock `launcherx` stays enabled. The setup wizard
(`setupwraith`) is kept enabled here, and to be disabled only before installing a custom launcher.

Apply: `TV_HOST=<tv ip> tools/disable.sh examples/tcl-g08-eu-android12/debloat.txt`
Undo: `TV_HOST=<tv ip> tools/restore.sh examples/tcl-g08-eu-android12/debloat.txt`

## Second unit: 75Q7C on AS36, with the launcher

TCL 75Q7C, same `G08_4K_GB` product and "Smart TV Pro" model, firmware `STT2.221228.001 AS36` (one build newer),
Spain, on Ethernet. Tested 25 October 2026, one day, one reboot.

- **The list applied unchanged.** `com.tcl.browser` is not on AS36. AS36 adds `com.tcl.channelplus`,
  `com.tcl.esticker`, `com.tcl.usercenter`, `com.tcl.waterfall.overseas` and `com.tcl.guard`, which the Q7C and
  US G08 lists disable; they were disabled here too, and were commented in `debloat.txt` until someone had lived
  with them longer (four are in the list since the third unit). `com.tcl.suspension`, `com.tcl.interactive` and
  `com.tcl.ttvs` stayed enabled: the Input key opened the source panel throughout.
- **Owner's choices, not in the list:** Chromecast (`com.google.android.apps.mediashell`), AirPlay
  (`com.mediatek.AirplayAPK`, `com.tcl.airplay2` with the daemon), Miracast (`com.tcl.miracast`), YouTube Music,
  the USB media player (`com.tcl.ui_mediaCenter`) and `com.tcl.gallery` were disabled; the game bar was kept.
  `com.google.android.apps.tv.dreamx` (the Google photo screensaver) was disabled and later re-enabled: it runs
  without `launcherx`, after the system's `screen_off_timeout`.
- **Launcher as Home.** No Wi-Fi network was saved (`dumpsys wifi` showed no `cname=`), so
  `FORCE_SETUPWRAITH=1 tools/disable.sh` with `launcherx` and `setupwraith` was safe. It disabled `launcherx` in
  the same run: Projectivy Launcher was installed, so the Home guard saw another app that could take Home, as
  designed. Then `STOCK_LAUNCHER=none INPUT_KEY_SERVICE=1 HOME_KEY_SERVICE=1 launcher/build-and-install.sh`
  (`STOCK_LAUNCHER=none` because the script does not know Projectivy). After a reboot Home was the new launcher,
  both key helpers were bound, and all disabled packages stayed disabled.

### Remote buttons (this unit's remote)

Read from `logcat` (`handleKeyBeforeQueueing ... keyCode=`) while pressing the real buttons. Home, Input, the mic,
Netflix, Prime Video and Disney+ worked without any mapping (the TCL firmware handles them).

| Button | Keycode | Mapped with |
|---|---|---|
| Settings (gear) | 83 | `settings_key_keycodes: [83]`, `HOME_KEY_SERVICE=1` |
| YouTube | 4065 (not 190 as on the Q7C list) | `app_keys`, `INPUT_KEY_SERVICE=1` |
| TCL | 4020 | `app_keys` |
| Media | 4057 | unmapped |

**The trade:** with the helpers bound, holding Volume + moves one step per press instead of ramping, as on the G09
in [`docs/devices/tcl-55p71b-g09-key-repeat.md`](../../docs/devices/tcl-55p71b-g09-key-repeat.md). `logcat`
showed one `ACTION_DOWN` and one volume change for a two-second hold. `consume_volume_keys` did not bring the
ramp back: the launcher's own repeat never ran, so the helpers do not seem to see the volume key on this build.
The owner kept the buttons.

## Third unit: 50C805X1 on AS34, with the launcher

TCL 50C805X1, same `G08_4K_GB` product and "Smart TV Pro" model, firmware `STT2.221228.001 AS34` like the first
set, France, on Wi-Fi. Applied 23 October 2026 with `tools/disable.sh` and lived with until 26 October; every
disabled package was still disabled after two reboots.

- **The AS36 preloads are on this AS34 set too.** It ships `com.mediatek.AirplayAPK`, `com.tcl.channelplus`,
  `com.tcl.esticker`, `com.tcl.usercenter`, `com.tcl.waterfall.overseas` and `com.tcl.guard`, so they depend on
  the set or the region, not on the build. The first four were disabled for three days with nothing missed and
  are now in `debloat.txt`. `com.tcl.guard` is not: disabled, the system tried to start its
  `.memorymanager.TGuardService` every 5 seconds (`Unable to start service ... not found` in `logcat`), and the
  retries stopped once it was re-enabled.
- **Added to the list:** Google feedback, calendar sync, `onetimeinitializer` and Play Games.
- **Owner's choices, not in the list:** YouTube Music, Rakuten TV (`tv.wuaki.apptv`) and the USB media player
  (`com.tcl.ui_mediaCenter`) were disabled; TTS, AirPlay (`com.mediatek.airplaydaemon` with `AirplayAPK` and
  `com.tcl.airplay2`) and MagicConnect were kept. `com.tcl.browser` is not on this set.
- **Launcher as Home.** `setupwraith` owned a saved Wi-Fi network the TV no longer used (`dumpsys wifi`,
  `cname=com.google.android.tungsten.setupwraith`). Once it was forgotten in Settings, `tools/disable.sh`
  disabled `setupwraith` without `FORCE_SETUPWRAITH`, and `launcher/build-and-install.sh` found `launcherx` and
  disabled it.
- **Casting still works with `setupwraith` disabled**, after a reboot: YouTube on a phone passed the Cast device
  check (`CastV2.Authenticate` challenge and response in `cast_shell`'s log) and played, and so did a cast to the
  Default Media Receiver. This set does not show the "Untrusted device" failure in
  [TROUBLESHOOTING](../../docs/TROUBLESHOOTING.md); the only trace is the voice app (`katniss`) logging
  `Failed to get cast id and certificate from Content Provider`, with nothing visible.
- **Voice, with `com.tcl.eva` disabled:** the mic works and app commands ("open Netflix") work. A search for a
  film opens nothing, because the results page is `launcherx`'s (the voice-search entry in TROUBLESHOOTING).

### Remote buttons (this unit's remote)

With `launcherx` disabled and no key helper, Netflix, Prime Video, YouTube, TCL Channel and TCL Home did nothing.
Web still opened the Play Store. Codes read from `logcat` (`handleKeyBeforeQueueing ... keyCode=`, `scanCode=`) while
pressing the real buttons:

| Button | Keycode | Scancode |
|---|---|---|
| Netflix | 4062 | 242 |
| Prime Video | 4099 | 752 |
| YouTube | 4065 | 245 |
| TCL Channel | 4020 | 456 |
| TCL Home | 4137 | 204 |
| Settings (gear) | 83 | |

`app_keys` by scancode (`scan:242:...`) with `INPUT_KEY_SERVICE=1` made them work, at the cost of the volume
ramp, as on the second unit: with any key helper bound, holding Volume moved one step; with none, it ramps.
Re-enabling `launcherx` to answer the buttons does not work either: it takes Home back as soon as it is enabled.
