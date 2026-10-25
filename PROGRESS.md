# Progress — CleanYourTV-UI (Philips 58PUS8507/12)

## Current state
- `CleanYourTV-UI` (`io.cleanyourtv.ui`) default launcher olarak aktif ve kusursuz çalışıyor.
- Öneri kartlarında sayfalama ve sağ/sol gezinme okları (`‹  2 / 8  ›` ve kenar okları) eklendi.
- Çekmece açılırken ve gezinirken öneri kartları ve ekran bileşenleri senkronize şekilde kayar, metin çakışması ve ani kaybolma giderildi.
- Profil butonu doğrudan Android TV'nin "Hesaplar ve oturum açma" (iris.ulstrn@gmail.com) ekranına yönlendiriyor.
- Ayarlardaki TMDB hesap alanı "TMDB Hesabı · Bağlı değil (İsteğe bağlı)" olarak Türkçeleştirildi; API'nin zaten 24 içeriği bağımsız çektiği kullanıcıya netleştirildi.
- Sıcaklık Türkiye ve tüm Avrupa'da otomatik Santigrat (°C).

## Decisions
- 2026-10-25: Öneri kartları sayfalama için `‹  X / Y  ›` formatı ve sağ/sol yönlendirme okları (`‹`, `›`) eklendi.
- 2026-10-25: `HomeView.java` `updateMotion()` içinde katmanların senkronize kayması (`lift`) sağlandı, opaklık yumuşatıldı.
- 2026-10-25: `Turkish.java` içinde TMDB hesap ve bağlantı durumu Türkçeleştirildi.

## Open issues / Next
- Tüm kullanıcı talepleri tamamlandı ve TV üzerinde doğrulandı.

## Log
- 2026-10-25: Öneri sağ/sol yön okları, sayfa göstergesi, kaydırma yumuşatma ve TMDB etiket Türkçeleştirmesi — `HomeView.java`, `Turkish.java` — TV'ye kuruldu ve doğrulandı.
- 2026-10-25: Profil butonu doğrudan "Hesaplar ve oturum açma"ya yönlendirildi — `HomeApps.java`.
- 2026-10-25: GitHub CI workflows silindi (faturalandırma e-postaları durduruldu).
