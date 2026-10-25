# CleanYourTV-UI (Türkçe & TMDB Destekli Android TV Başlatıcı)

Hafif, reklamsız, akıcı ve televizyonunuzun orijinal sistem servislerine zarar vermeyen modern Android TV başlatıcısı (Launcher).

![CleanYourTV-UI Türkçe Ekran Görüntüsü](screenshot.png)

> **Kaynak & Teşekkür (Credits):**  
> Bu proje, **[Matheus Caldeira (matheus-caldeira/cleanyourtv-ui)](https://github.com/matheus-caldeira/cleanyourtv-ui)** tarafından geliştirilen harika `cleanyourtv-ui` çalışmasının Türkçe yerelleştirilmiş ve Türkiye için optimize edilmiş fork'udur. Matheus Caldeira'ya açık kaynak katkısı için teşekkür ederiz.

---

## Uyumluluk ve Test Edilen Modeller / Device Compatibility

- **Bizzat Test Edilip Doğrulanan Model:**  
  **Philips 58PUS8507/12 (58PUS8507/62, Android TV 11)** — TMDB öneri kartları, Türkçe menüler, sağ üst Wi-Fi hızlı ayar butonu ve akıcı kumanda navigasyonu test edilip tam kararlılıkla çalıştığı doğrulanmıştır.
- **Diğer Android TV & TV Box Cihazları:**  
  Android TV 9, 10, 11, 12, 13 ve 14 çalıştıran televizyon ve TV kutuları (Sony, TCL, Xiaomi Mi Box, Chromecast with Google TV vb.) için uygundur.  
  *Farklı üreticilerin launcher kısıtlamaları veya özel arayüzleri nedeniyle tüm cihazlarda %100 uyumluluk garanti edilemez; lütfen cihazınızda deneyip geri bildirimde bulunun.*

---

## Bu Sürümde Yapılan Yenilikler

- **Tam Türkçe Arayüz:** Ayarlar, menüler, kategoriler, film ve dizi türleri (`Aksiyon & Macera`, `Dizi`, `Film`, `Belgesel` vb.) tamamen Türkçeleştirildi.
- **TMDB Türkiye Optimizasyonu:** `tr-TR` dil ve `TR` bölge desteği getirildi. Ana sayfadaki 3 vitrin kartında Türkçe yerel başlığı bulunan içerikler önceliklendirildi.
- **Hava Durumu ve Para Birimi:** Hava durumu durumları Türkçe yapıldı, döviz ve piyasa göstergelerine Türk Lirası (`₺`) eklendi.
- **Sağ Üst Wi-Fi Hızlı Erişim Butonu:** Ana sayfanın sağ üst köşesine TV'nin kendi Wi-Fi ve Ağ Ayarları ekranını tek tuşla açan özel bir buton eklendi.
- **Sıfır Debloat:** Televizyonun fabrika servislerini veya orijinal ana ekranını silmez; güvenli bir şekilde varsayılan başlatıcı olarak çalışır.

---

## Adım Adım Kurulum Rehberi

### 1. Televizyonda ADB Hata Ayıklamayı Açma
1. TV'de **Ayarlar (Settings)** -> **Cihaz Tercihleri** -> **Hakkında** yolunu izleyin.
2. **Android TV Derlemesi (Build)** seçeneğine kumandanın **OK** tuşuyla **7 kez** arka arkaya basın (*"Artık bir geliştiricisiniz"* bildirimi çıkana kadar).
3. Geri gelip **Geliştirici Seçenekleri** menüsüne girin ve **USB Hata Ayıklama (USB Debugging)** seçeneğini açın.
4. **Ayarlar** -> **Ağ ve İnternet** kısmından TV'nizin yerel IP adresini not edin (örnek: `192.168.1.50`).

### 2. Uygulamayı Televizyona Yükleme ve Varsayılan Yapma
[Releases](https://github.com/ichZara/CleanYourTV-UI-TR/releases) sayfasından indirdiğiniz `CleanYourTV-UI.apk` dosyasını ADB ile yükleyin:

```bash
# 1. Televizyona kablosuz bağlanın:
adb connect <TELEVIZYON_IP_ADRESI>:5555
# (Televizyon ekranında 'Bu bilgisayara her zaman izin verilsin mi?' kutucuğu çıkar, kumandayla 'Her zaman izin ver'i işaretleyip OK deyin)

# 2. APK'yı yükleyin:
adb install -r CleanYourTV-UI.apk

# 3. Televizyonun varsayılan ana ekranı (Home) yapın:
adb shell cmd package set-home-activity io.cleanyourtv.ui/.HomeActivity
```

*(Orijinal TV ana ekranına dönmek isterseniz istediğiniz an TV ayarlarından başlatıcıyı değiştirebilirsiniz, hiçbir sistem dosyası silinmez).*

---

## Yapay Zeka (AI) ile Otomatik Kurulum Promptu / AI Prompt for Setup

Aşağıdaki hazır promptu kopyalayıp kullandığınız yapay zeka asistanına (ChatGPT, Claude, Gemini veya terminal AI aracınıza) vererek kurulumu baştan sona ona yaptırabilirsiniz:

````markdown
Aşağıdaki GitHub deposunu kullanarak Android TV'me hafif ve Türkçe CleanYourTV başlatıcısını kurmak istiyorum:
Repo: https://github.com/ichZara/CleanYourTV-UI-TR
Televizyonumun yerel IP adresi: [BURAYA_TELEVIZYONUN_IP_ADRESINI_YAZIN, örn: 192.168.1.50]

Lütfen şu adımları benim için sırasıyla açıkla veya terminal komutlarıyla çalıştır:
1. Depodaki son sürüm APK'yı (CleanYourTV-UI.apk) indir veya depoyu klonlayıp derle.
2. Bilgisayarımdan ADB ile yukarıdaki televizyon IP adresine bağlan.
3. APK'yı televizyona yükle ve televizyonun varsayılan ana ekranı olarak ayarla.
4. Hata alırsam (örneğin cihaz bulunamadı veya bağlantı reddedildi) nasıl düzelteceğimi belirt.
````

---

## Hatalar ve Geri Bildirim / Issue Reporting

Herhangi bir hata, çökme veya görsel sorun yaşarsanız lütfen **[GitHub Issues](https://github.com/ichZara/CleanYourTV-UI-TR/issues)** üzerinden bize bildirin!

Hata bildirirken televizyonunuzun marka/modelini ve Android sürümünü yazmanız sorunun hızla giderilmesini sağlayacaktır.

---

## Lisans

Açık kaynaklıdır. Orijinal `matheus-caldeira/cleanyourtv-ui` lisansına tabidir.
