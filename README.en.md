<p align="center">
  <a href="README.md">Türkçe</a> | <b>English</b>
</p>

# CleanYourTV-UI (Lightweight & Ad-Free Android TV Launcher)

A fast, minimalist, ad-free Android TV launcher that provides an Apple TV-like clean experience without breaking or debloating your television's original factory system services.

<p align="center">
  <img src="screenshot.png" alt="CleanYourTV-UI Screenshot" width="720"/>
</p>

> **Credits & Acknowledgements:**  
> This project is built upon the open-source **CleanYourTV** ecosystem created by **[Gathin (Gathin23/cleanyourtv)](https://github.com/Gathin23/cleanyourtv)** and the UI fork by **[Matheus Caldeira (matheus-caldeira/cleanyourtv-ui)](https://github.com/matheus-caldeira/cleanyourtv-ui)**. We added Turkish localization, TMDB spotlight improvements, navigation arrows, smooth remote scrolling, customizable theme modes, interactive screensaver styles, and hardware optimizations. Special thanks to Gathin and Matheus Caldeira for their foundational contributions to the open-source community!

---

## Table of Contents
- [Why CleanYourTV-UI?](#why-cleanyourtv-ui)
- [Key Features](#key-features)
- [Device Compatibility](#device-compatibility)
- [Step-by-Step Installation](#step-by-step-installation)
- [AI-Assisted Installation Prompt](#ai-assisted-installation-prompt)
- [Configuration (config.properties)](#configuration-configproperties)
- [Issues & Support](#issues--support)
- [License](#license)

---

## Why CleanYourTV-UI?
Factory Android TV and Google TV home screens have become bloated with banner advertisements, sponsored video autoplay, and background telemetry services that cause noticeable remote lag and slow down your TV.

CleanYourTV-UI replaces the heavy default home screen with an ultra-lightweight, fluid interface. It respects your TV: **no root required**, **no aggressive debloating**, and **no brick risk**. You can revert back to your factory launcher at any time with a single command or setting.

---

## Key Features
- **Header Digital Clock & Temperature:** Elegant live digital clock and local weather temperature in the top-right corner of the home screen, updating every minute.
- **Instant Wi-Fi Quick Access:** Dedicated top-right network button opening TV system Wi-Fi / Ethernet settings (`NetworkActivity`) with one click.
- **Theme Modes (Dark / Light / Dynamic):** Choose permanent Dark, permanent Light, or Auto (dynamically adjusts to local sunrise and sunset).
- **Screensaver Styles:**
  - *Cinematic (Recommendations):* High-resolution movie/TV series backdrops with a minimalist clock.
  - *Matrix (Digital Rain):* Falling green code stream.
  - *Clock & Aurora:* Ambient northern lights animation with large frosted-glass clock.
  - Switch styles directly from settings with Left/Right keys and live preview with OK.
- **TMDB Recommendations:** 3 spotlight cards curated with popular movies and TV shows from The Movie Database (TMDB).
- **Zero Bloat & Minimum RAM Usage:** No telemetry, zero tracking, no ads, lightweight memory footprint.
- **Safe & Non-Destructive:** Works via Android TV standard `cmd package set-home-activity`. Never modifies core system partitions.

---

## Device Compatibility
- **Tested & Verified Model:**  
  **Philips 58PUS8507/12 (58PUS8507/62, Android TV 11)** — Verified with TMDB cards, Turkish/English UI, top-right clock/weather, Wi-Fi quick button, and responsive remote navigation.
- **General Compatibility:**  
  Compatible with smart TVs, TV sticks, and boxes running Android TV 9, 10, 11, 12, 13, and 14 (Sony, Philips, TCL, Xiaomi Mi Box / TV Stick, Chromecast with Google TV, Onn 4K, etc.).  
  > [!IMPORTANT]
  > Because TV manufacturers apply distinct custom launcher policies and restrictions, 100% plug-and-play behavior cannot be guaranteed on every single OEM build. Please open an issue if you encounter quirks on your device!

---

## Step-by-Step Installation

### 1. Enable ADB Debugging on Your TV
1. On your TV, navigate to **Settings** -> **Device Preferences** -> **About**.
2. Scroll to **Android TV OS Build** and press **OK** on your remote **7 times** until you see *"You are now a developer!"*.
3. Go back to **Developer Options** and turn on **USB Debugging / Network Debugging**.
4. Check **Settings** -> **Network & Internet** to get your TV's local IP address (e.g., `192.168.1.50`).

### 2. Install and Set as Default Launcher

#### Method A: Download Pre-built Release APK (Fastest)
1. Download `CleanYourTV-UI.apk` from the **[Releases](https://github.com/ichZara/CleanYourTV-UI-TR/releases)** page.
2. Open PowerShell or Terminal on your computer and run:
   ```bash
   # Connect to your TV over Wi-Fi:
   adb connect <TV_IP_ADDRESS>:5555
   # (Accept the 'Always allow from this computer' prompt on your TV screen)

   # Install the launcher:
   adb install -r CleanYourTV-UI.apk

   # Set as the default home screen:
   adb shell cmd package set-home-activity io.cleanyourtv.ui/.HomeActivity
   ```

#### Method B: Build from Source
```bash
git clone https://github.com/ichZara/CleanYourTV-UI-TR.git
cd CleanYourTV-UI-TR/launcher-ui
./build.sh
adb connect <TV_IP_ADDRESS>:5555
adb install -r CleanYourTV-UI.apk
adb shell cmd package set-home-activity io.cleanyourtv.ui/.HomeActivity
```

---

## AI-Assisted Installation Prompt
If you prefer your AI assistant (Claude, ChatGPT, Gemini, or terminal agent) to handle the ADB steps for you, copy and paste this prompt:

````markdown
I want to install the lightweight CleanYourTV launcher on my Android TV using this GitHub repository:
Repo: https://github.com/ichZara/CleanYourTV-UI-TR
My TV IP address: [INSERT_YOUR_TV_IP_HERE, e.g. 192.168.1.50]

Please guide me or execute the following steps via terminal commands:
1. Download the latest release APK (CleanYourTV-UI.apk) from the repository.
2. Connect to my TV via ADB over Wi-Fi using the IP address provided above.
3. Install the APK and set it as the default home activity.
4. If there are any connection issues (device unauthorized or port closed), provide troubleshooting instructions.
````

---

## Configuration (`config.properties`)
Optionally add your own free TMDB API v3 key to `launcher-ui/config.properties`:

```properties
tmdb.key=YOUR_TMDB_API_KEY
language=en
region=US
```

---

## Issues & Support
If you encounter bugs, layout misalignments, or crashes, please report them via **[GitHub Issues](https://github.com/ichZara/CleanYourTV-UI-TR/issues)**.  
When reporting, including your **TV brand, exact model code, and Android TV version** helps resolve issues faster.

---

## Support / Buy Me a Coffee
If you enjoy this project and would like to support ongoing development:

[![Buy Me A Coffee](https://img.shields.io/badge/Buy%20Me%20A%20Coffee-ichzara-yellow?style=for-the-badge&logo=buy-me-a-coffee&logoColor=black)](https://buymeacoffee.com/ichzara)

Direct link: **[buymeacoffee.com/ichzara](https://buymeacoffee.com/ichzara)**

---

## License
Open source under the MIT License. Derived from original works by **[Gathin (Gathin23/cleanyourtv)](https://github.com/Gathin23/cleanyourtv)** and **[Matheus Caldeira (matheus-caldeira/cleanyourtv-ui)](https://github.com/matheus-caldeira/cleanyourtv-ui)**.
