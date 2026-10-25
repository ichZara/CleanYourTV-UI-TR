# CleanYourTV-UI (Türkçe & TMDB Destekli Android TV Launcher)

Hafif, reklamsız, akıcı ve gizlilik odaklı Android TV başlatıcısı (Launcher).

Orijinal televizyon sistem servislerini devre dışı bırakmadan (`no debloat`), modern Google TV / Apple TV benzeri kart ve öneri yapısı sunar.

---

## Öne Çıkan Özellikler

- **Tam Türkçe Arayüz:** Tüm ayarlar, menüler, kategoriler ve hava durumu bilgileri Türkçeleştirildi.
- **TMDB Entegrasyonu (tr-TR / TR):**
  - Film ve dizi türleri Türkçe (`Aksiyon & Macera`, `Dizi`, `Film` vb.).
  - Ana ekrandaki 3 vitrin kartında yerelleştirilmiş Türkçe başlıklar önceliklendirilir.
- **Sağ Üst Wi-Fi & Ağ Hızlı Erişim İkonu:** TV'nin yerel ağ ve kablosuz bağlantı ayarlarını (`NetworkActivity`) tek tıkla açan özel buton.
- **Sıfır Donma & Minimum RAM Tüketimi:** Gereksiz arka plan servisleri veya telemetri barındırmaz.
- **Güvenli Varsayılan:** Orijinal başlatıcıyı silmez veya bozmaz; Android TV standart `cmd package set-home-activity` ile çalışır.

---

## Cihaz Uyumluluk Bildirimi

- **Bizzat Test Edilip Doğrulanan Model:**  
  **Philips 58PUS8507/12 (58PUS8507/62, Android TV 11)** — TMDB öneri kartları, Türkçe menüler, sağ üst dijital saat ve sıcaklık göstergesi, Wi-Fi hızlı ayar butonu ve akıcı kumanda navigasyonu test edilmiş ve tam kararlılıkla çalıştığı doğrulanmıştır.
- **Diğer Cihazlar:**  
  Android TV 9, 10, 11, 12, 13 ve 14 çalıştıran tüm akıllı televizyon ve TV kutuları (Sony, TCL, Xiaomi Mi Box / TV Stick, Chromecast with Google TV vb.) için uygundur.

---

## Kurulum

1. Depoyu derleyin veya `CleanYourTV-UI.apk` dosyasını edinin:
   ```bash
   cd launcher-ui
   ./build.sh
   ```

2. ADB üzerinden televizyonunuza yükleyin:
   ```bash
   adb connect <TV_IP_ADRESI>:5555
   adb install -r CleanYourTV-UI.apk
   ```

3. Varsayılan ana ekran olarak ayarlayın:
   ```bash
   adb shell cmd package set-home-activity io.cleanyourtv.ui/.HomeActivity
   ```

---

## Yapılandırma (`config.properties`)

İsteğe bağlı olarak `launcher-ui/config.properties` içine kendi TMDB API v3 anahtarınızı ekleyebilirsiniz:

```properties
tmdb.key=BURAYA_TMDB_API_KEY
language=tr
region=TR
```

---

## Lisans

Bu proje açık kaynaklıdır. Orijinal `cleanyourtv-ui` çalışması üzerine geliştirilmiştir.

---

## Diğer Projeler
Geliştirdiğim diğer açık kaynaklı Android TV ve akıllı ev projelerine göz atmak için **[GitHub Profilimi (@ichZara)](https://github.com/ichZara)** ziyaret edebilirsiniz.
