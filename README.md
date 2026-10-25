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

## Adım Adım Kurulum Rehberi

Kurulumu ister aşağıdaki adımları izleyerek yapabilir, isterseniz hazır yapay zeka (AI) promptunu ChatGPT / Claude / Gemini'ye kopyalayarak tüm kurulumu ona yaptırabilirsiniz.

### 1. Televizyonda Geliştirici Seçenekleri ve Hata Ayıklamayı Açma
1. Televizyonunuzda **Ayarlar (Settings)** -> **Cihaz Tercihleri** -> **Hakkında** bölümüne gidin.
2. En altta bulunan **Android TV Derlemesi (Build)** seçeneğine gelin ve kumandanın **OK (Orta)** tuşuna arka arkaya **7 kez** hızlıca basın. Ekranda *"Artık bir geliştiricisiniz!"* bildirimi çıkacaktır.
3. Bir önceki menüye dönüp **Geliştirici Seçenekleri**'ne girin.
4. **USB Hata Ayıklama (USB Debugging)** seçeneğini aktif hale getirin.
5. TV'nizin IP adresini öğrenin (**Ayarlar** -> **Ağ ve İnternet** -> Bağlı olduğunuz Wi-Fi'ye tıklayın, örn: `192.168.1.50`).

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

*(İstediğiniz zaman TV Ayarlarından veya kumandanın Home tuşu ayarlarından fabrika ana ekranına geri dönebilirsiniz, orijinal sistem dosyaları asla silinmez).*

---

## Yapay Zeka (AI) ile Otomatik Kurulum Promptu

ADB komutlarıyla uğraşmak istemiyorsanız, aşağıdaki metni kopyalayıp kullandığınız yapay zekaya yapıştırın:

```markdown
Bilgisayarım ile aynı Wi-Fi ağına bağlı bir Android TV'm var.
Televizyonumun IP adresi: [BURAYA_TELEVIZYON_IP_ADRESINI_YAZIN]
İndirdiğim launcher dosyasının yolu: [BURAYA_INDIRILEN_CleanYourTV-UI.apk_DOSYA_YOLUNU_YAZIN]

Lütfen bilgisayarımdan ADB aracılığıyla televizyonuma bağlanıp bu launcher APK'sını kurmamı ve televizyonda varsayılan ana ekran olarak ayarlamamı sağlayan adımları ve komutları çalıştır veya bana sırasıyla yaz.
```

---

## Hatalar ve Geri Bildirim / Issue Reporting

Herhangi bir hata, çökme veya görsel sorun yaşarsanız lütfen **[GitHub Issues](https://github.com/ichZara/CleanYourTV-UI-TR/issues)** üzerinden bize bildirin!

Hata bildirirken televizyonunuzun marka/modelini ve Android sürümünü yazmanız sorunun hızla giderilmesini sağlayacaktır.

---

## Lisans

Açık kaynaklıdır. Orijinal `matheus-caldeira/cleanyourtv-ui` lisansına tabidir.
