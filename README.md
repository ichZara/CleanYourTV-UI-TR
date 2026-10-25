# CleanYourTV-UI (Türkçe & TMDB Destekli Android TV Başlatıcı)

Hafif, reklamsız, akıcı ve televizyonunuzun orijinal sistem servislerine zarar vermeyen modern Android TV başlatıcısı (Launcher).

![CleanYourTV-UI Türkçe Ekran Görüntüsü](screenshot.png)

> **Kaynak & Teşekkür (Credits):**  
> Bu proje, **[Matheus Caldeira (matheus-caldeira/cleanyourtv-ui)](https://github.com/matheus-caldeira/cleanyourtv-ui)** tarafından geliştirilen harika `cleanyourtv-ui` çalışmasının Türkçe yerelleştirilmiş ve Türkiye için optimize edilmiş fork'udur. Matheus Caldeira'ya açık kaynak katkısı için teşekkür ederiz.

---

## Uyumluluk ve Test Edilen Modeller

- **Bizzat Test Edilip Doğrulanan Model:** **Philips 58PUS8507/12 (58PUS8507/62, Android TV 11)** üzerinde tüm fonksiyonlarıyla (TMDB kartları, Türkçe arayüz, hızlı Wi-Fi ayar geçişi, akıcı kumanda navigasyonu) test edilmiş ve sıfır donma/kararlılık ile çalıştığı doğrulanmıştır.
- **Genel Uyumluluk:** Android TV 9, 10, 11, 12, 13 ve 14 çalıştıran **tüm akıllı televizyon ve TV Box cihazlarında** (Sony, Philips, TCL, Xiaomi Mi Box / TV Stick, Chromecast with Google TV vb.) sorunsuz çalışır.

---

## Bu Sürümde Yapılan Yenilikler

- **Tam Türkçe Arayüz:** Ayarlar, menüler, kategoriler, film ve dizi türleri (`Aksiyon & Macera`, `Dizi`, `Film`, `Belgesel` vb.) tamamen Türkçeleştirildi.
- **TMDB Türkiye Optimizasyonu:** `tr-TR` dil ve `TR` bölge desteği getirildi. Ana sayfadaki 3 vitrin kartında Türkçe yerel başlığı bulunan içerikler önceliklendirildi.
- **Hava Durumu ve Para Birimi:** Hava durumu durumları Türkçe yapıldı, döviz ve piyasa göstergelerine Türk Lirası (`₺`) eklendi.
- **Sağ Üst Wi-Fi Hızlı Erişim Butonu:** Ana sayfanın sağ üst köşesine TV'nin kendi Wi-Fi ve Ağ Ayarları ekranını tek tuşla açan özel bir buton eklendi.
- **Sıfır Debloat:** Televizyonun fabrika servislerini veya orijinal ana ekranını silmez; güvenli bir şekilde varsayılan başlatıcı olarak çalışır.

---

## Kurulum

Doğrudan [Releases](https://github.com/ichZara/CleanYourTV-UI-TR/releases) sayfasından hazır derlenmiş `CleanYourTV-UI.apk` dosyasını indirebilirsiniz.

1. ADB ile televizyonunuza yükleyin:
   ```bash
   adb connect <TV_IP_ADRESI>:5555
   adb install -r CleanYourTV-UI.apk
   ```

2. Varsayılan ana ekran olarak ayarlayın:
   ```bash
   adb shell cmd package set-home-activity io.cleanyourtv.ui/.HomeActivity
   ```

---

## Yapılandırma (`config.properties`)

İsteğe bağlı olarak `launcher-ui/config.properties` dosyasına kendi ücretsiz TMDB API anahtarınızı tanımlayabilirsiniz:

```properties
tmdb.key=BURAYA_TMDB_API_KEY
language=tr
region=TR
```

---

## Lisans

Açık kaynaklıdır. Orijinal `matheus-caldeira/cleanyourtv-ui` lisansına tabidir.
