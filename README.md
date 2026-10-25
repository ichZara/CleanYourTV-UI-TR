# CleanYourTV-UI (TR & EN)

Lightweight, ad-free, fast, and privacy-first Android TV launcher with TMDB integration.  
*Hafif, reklamsız, akıcı, gizlilik odaklı ve TMDB destekli Android TV başlatıcısı.*

---

## English

### Overview
CleanYourTV-UI provides a clean, modern Apple TV & Google TV style launcher experience without bloating system resources or deleting factory Android TV packages.

### Features
- **Bilingual Interface:** Full Turkish and English localization for all menus, settings, and genres.
- **TMDB Smart Recommendations (`tr-TR` / `TR`):**
  - Genre labels in Turkish (`Aksiyon & Macera`, `Dizi`, `Film`, etc.).
  - Prioritizes localized titles on the 3 main showcase cards.
- **Dedicated Top-Right Wi-Fi Icon:** One-click instant access to TV's native Wi-Fi & network settings (`NetworkActivity`).
- **Zero Debloat Philosophy:** Does not delete or break system packages; seamlessly integrates as standard default launcher via `cmd package set-home-activity`.
- **Low Memory & Battery Friendly:** No telemetry, background tracking, or heavy animation overhead.

### Installation
1. Build or get `CleanYourTV-UI.apk`:
   ```bash
   cd launcher-ui
   ./build.sh
   ```
2. Install via ADB:
   ```bash
   adb connect <TV_IP_ADDRESS>:5555
   adb install -r CleanYourTV-UI.apk
   ```
3. Set as default home launcher:
   ```bash
   adb shell cmd package set-home-activity io.cleanyourtv.ui/.HomeActivity
   ```

### Optional TMDB Configuration
Edit `launcher-ui/config.properties`:
```properties
tmdb.key=YOUR_TMDB_API_KEY
language=tr
region=TR
```

---

## Türkçe

### Genel Bakış
CleanYourTV-UI, orijinal televizyon sistem servislerini devre dışı bırakmadan (`no debloat`), modern Google TV ve Apple TV benzeri kart ve öneri yapısı sunan ultra hafif bir başlatıcıdır.

### Özellikler
- **Tam Türkçe Arayüz:** Tüm ayarlar, menüler, kategoriler ve hava durumu bilgileri Türkçeleştirildi.
- **TMDB Entegrasyonu (`tr-TR` / `TR`):**
  - Film ve dizi türleri Türkçe (`Aksiyon & Macera`, `Dizi`, `Film` vb.).
  - Ana ekrandaki vitrin kartlarında yerelleştirilmiş Türkçe başlıklar önceliklendirilir.
- **Sağ Üst Wi-Fi & Ağ Hızlı Erişim İkonu:** TV'nin yerel ağ ve kablosuz bağlantı ayarlarını (`NetworkActivity`) tek tıkla açan özel buton.
- **Sıfır Donma & Minimum RAM Tüketimi:** Gereksiz arka plan servisleri veya telemetri barındırmaz.
- **Güvenli Varsayılan:** Orijinal başlatıcıyı silmez veya bozmaz; Android TV standart `cmd package set-home-activity` ile çalışır.

### Kurulum
1. Derleyin:
   ```bash
   cd launcher-ui
   ./build.sh
   ```
2. ADB üzerinden televizyonunuza yükleyin:
   ```bash
   adb connect <TV_IP_ADRESI>:5555
   adb install -r CleanYourTV-UI.apk
   ```
3. Varsayılan ana ekran yapın:
   ```bash
   adb shell cmd package set-home-activity io.cleanyourtv.ui/.HomeActivity
   ```

---

## License / Lisans
Open source, based on `cleanyourtv-ui`.
