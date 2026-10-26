# Progress — CleanYourTV-UI (Philips 58PUS8507/12)

## Current state
- `CleanYourTV-UI` (`io.cleanyourtv.ui`) default launcher olarak aktif ve kusursuz çalışıyor.
- Tema ayarları eklendi: Koyu (varsayılan), Açık ve Otomatik (Gündoğumu/Günbatımı).
- Ekran koruyucu ayarları ve tarz seçici eklendi: Sinematik (TMDB Afişleri), Matrix (Dijital Yağmur) ve Saat ve Aurora.
- Ayarlardan doğrudan canlı önizleme ve Android TV sistem ekran koruyucusu ayarlarına geçiş eklendi.
- Öneri kartlarında sayfalama ve sağ/sol gezinme okları (`‹  2 / 8  ›` ve kenar okları) eklendi.
- Çekmece açılırken ve gezinirken öneri kartları ve ekran bileşenleri senkronize şekilde kayar.
- Profil butonu doğrudan Android TV'nin "Hesaplar ve oturum açma" ekranına yönlendiriyor.
- Ayarlardaki TMDB hesap alanı "TMDB Hesabı · Bağlı değil (İsteğe bağlı)" olarak Türkçeleştirildi.
- Sıcaklık Türkiye ve tüm Avrupa'da otomatik Santigrat (°C).

## Decisions
- 2026-10-26: `SettingsActivity.java`, `HomeView.java`, `Prefs.java`, `DreamView.java`, `RainView.java` ile tema (Koyu/Açık/Otomatik) ve ekran koruyucu tarzı (Sinematik/Matrix/Aurora) tam entegre edildi.
- 2026-10-25: Öneri kartları sayfalama için `‹  X / Y  ›` formatı ve sağ/sol yönlendirme okları (`‹`, `›`) eklendi.
- 2026-10-25: `HomeView.java` `updateMotion()` içinde katmanların senkronize kayması (`lift`) sağlandı, opaklık yumuşatıldı.
- 2026-10-25: `Turkish.java` içinde TMDB hesap ve bağlantı durumu Türkçeleştirildi.

## Open issues / Next
- Tüm kullanıcı talepleri tamamlandı ve TV üzerinde canlı doğrulandı.

## Log
- 2026-10-26: Ayarlar menüsüne tema seçimi (Koyu/Açık/Otomatik), ekran koruyucu tarz seçici (Sinematik/Matrix/Aurora) ve test önizlemesi eklendi — `SettingsActivity.java`, `RainView.java`, `DreamView.java`, `Prefs.java`, `HomeView.java` — TV'de canlı test edildi.
- 2026-10-25: Öneri sağ/sol yön okları, sayfa göstergesi, kaydırma yumuşatma ve TMDB etiket Türkçeleştirmesi — `HomeView.java`, `Turkish.java` — TV'ye kuruldu ve doğrulandı.
- 2026-10-25: Profil butonu doğrudan "Hesaplar ve oturum açma"ya yönlendirildi — `HomeApps.java`.
