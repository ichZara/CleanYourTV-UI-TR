# Progress — CleanYourTV-UI (Philips 58PUS8507/12)

## Current state
- `CleanYourTV-UI` (`io.cleanyourtv.ui`) default launcher olarak çalışıyor.
- Profil butonu tıklandığında doğrudan Android TV'nin "Hesaplar ve oturum açma" (iris.ulstrn@gmail.com) ekranına yönlendiriyor.
- Sıcaklık Türkiye ve ABD dışındaki tüm ülkelerde otomatik Santigrat (°C, şu an 16°).
- Öneri kartlarındaki döngü ve beyaz arka plan düzeltildi.

## Decisions
- 2026-10-25: `HomeApps.profileSettings` hedefi `com.google.android.tv.settings.AccountActivity` yerine `com.android.tv.settings.MainSettings` yapıldı; böylece cihaz tercihleri yerine doğrudan kullanıcı hesapları ekranı açılıyor.
- 2026-10-25: Çekmece açıldığında öneri kartlarının tamamen ekrandan çıkması yerine görünür kalması için layout düzenlemesi yapılacak.

## Open issues / Next
- [Launcher] Aşağı kaydırınca (çekmece açıldığında) üstteki öneri kartlarının ekrandan kaybolmaması için kayma yüksekliğinin (`SHIFT`) ve görünümün ayarlanması.
- [Launcher] Profil isminin Google hesabının tam görünen isminden (display name) okunması veya ayarlardan manuel isim düzenlenebilmesi.
- [HomeKit] 7 yıl önceki eski kütüphane ve bağımlılıkların güncellenmesi (`app/build.gradle` ve `libs/hap`).
- [HomeKit] Siri ile YouTube / uygulama açma: HomeKit giriş kaynağı (InputSource) mantığı ve sadeleştirme.
- [HomeKit] Apple TV Remote'da iPhone donanım ses tuşlarının TV'ye bağlanması.

## Log
- 2026-10-25: Profil butonu doğrudan "Hesaplar ve oturum açma"ya yönlendirildi — `HomeApps.java` — TV'ye yüklendi ve push edildi.
- 2026-10-25: GitHub CI workflows silindi (faturalandırma e-postaları durduruldu).
- 2026-10-25: Öneri kartları sonsuz döngü donması ve beyaz ekran düzeltildi.
