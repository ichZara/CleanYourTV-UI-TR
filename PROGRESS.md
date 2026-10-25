# Progress — CleanYourTV-UI (Philips 58PUS8507/12)

## Current state
- `CleanYourTV-UI` (`io.cleanyourtv.ui`) installed and set as default launcher (`cmd package set-home-activity io.cleanyourtv.ui/.HomeActivity`) without disabling any factory/system packages.
- TMDB v3 API key configured (`tr-TR` language, `TR` watch region).
- Top bar layout (left-to-right): Hava durumu -> Saat -> TV Google hesap ismi (`İris`) -> Google profil avatar butonu (diğer butonlarla aynı boyutta) -> Keşfet -> HDMI -> Wi-Fi -> Ayarlar.
- Ana ekranda kartlar sağa/sola kaydırılabilir: 3'erli sayfalar halinde 24 içeriğe kadar gezinme (`1 / 8`, `2 / 8`...).
- Ayarlar ekranı nötr grafit/füme gri cam teması ve `ichZara · github.com/ichZara/CleanYourTV-UI-TR` TR sürümüyle güncellendi.
- Varsayılan tema "dark" yapılarak uyanışta veya gündüz oluşan beyaz tema/arka plan sorunu giderildi.
- Öneri kartlarındaki 1-2 saniyede bir griye düşüp yenilenme ve TV'yi donduran sonsuz önbellek döngüsü (cache thrashing) düzeltildi.

## Decisions
- 2026-10-25: Öneri kartları 24'e çıkarıldığında `updateCards()` tüm 48 içeriği RAM'e çekmeye çalışıyordu; görsel LRU önbelleği 10 ile sınırlı olduğu için her görsel bir diğerini siliyor ve `onRecs()` üzerinden sonsuz bir yenileme/yükleme döngüsü (thrashing) oluşuyordu. Bu durum kartların sürekli griye dönmesine ve TV'nin kilitlenmesine neden oluyordu. `updateCards()` sadece ekranda o an görünen 3 kartı yükleyecek şekilde optimize edildi.
- 2026-10-25: Varsayılan tema `"auto"` yerine `"dark"` yapıldı. Böylece Home ile veya kumandayla açıldığında gündüz dahi olsa launcher beyaz moda geçmez, karanlık temada kalır.
- 2026-10-25: Üst bar sırası kullanıcı isteğine göre hizalandı: Hava durumu -> Saat -> Gmail profil ismi -> Gmail profil ikonu (68*k dairesel buton) -> Diğer ikonlar.
- 2026-10-25: TV'ye bağlı Google hesabı `AccountManager` üzerinden çekildi (`iris.ulstrn@gmail.com` -> `İris`), tıklandığında Google TV hesap ayarlarına yönlendirildi.
- 2026-10-25: Gezinme sesleri varsayılan olarak kapatıldı ve ayarlara açma/kapama seçeneği eklendi.
- 2026-10-25: Cihaz saat/bölge formatı seçenekleri eklendi.
- 2026-10-25: Ayarlar arka planındaki mavi ton tamamen kaldırıldı; nötr koyu gri cam/füme efektine geçildi.

## Open issues / Next
- [HomeKit] iOS Ev uygulamasında TV aksesuarı arayüzündeki dağınık TIF giriş kaynaklarının filtrelenmesi ve sadeleştirilmesi.
- [HomeKit] Apple TV Remote kumandasında iPhone fiziksel ses tuşlarının TV sesine bağlanması (`TelevisionSpeaker` linked service).

## Log
- 2026-10-25: Öneri kartları sonsuz yenilenme/donma hatası ve beyaz arka plan düzeltildi — `HomeView.java`, `Prefs.java` — TV'ye kuruldu ve doğrulandı.
- 2026-10-25: Gmail profil entegrasyonu, üst bar buton sırası/boyutu, yatay kart sayfalandırma (1/8 .. 8/8), nötr gri ayarlar teması ve TR repo bağlantısı — verified on TV (`home_new.png`, `home_cards_paged.png`, `settings_neutral.png`).
- 2026-10-25: Gezinme sesleri sessiz varsayılanı + saat formatı ayarı + üst bar düzenlemeleri.
- 2026-10-25: Wi-Fi butonu ve tam Türkçe TMDB yerelleştirmesi.
