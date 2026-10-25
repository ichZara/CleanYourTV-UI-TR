# Progress — CleanYourTV-UI (Philips 58PUS8507/12)

## Current state
- `CleanYourTV-UI` (`io.cleanyourtv.ui`) installed and set as default launcher (`cmd package set-home-activity io.cleanyourtv.ui/.HomeActivity`) without disabling any factory/system packages.
- TMDB v3 API key configured (`tr-TR` language, `TR` watch region).
- Top bar layout (left-to-right): Hava durumu -> Saat -> TV Google hesap ismi (`İris`) -> Google profil avatar butonu (diğer butonlarla aynı boyutta) -> Keşfet -> HDMI -> Wi-Fi -> Ayarlar.
- Ana ekranda kartlar sağa/sola kaydırılabilir: 3'erli sayfalar halinde 24 içeriğe kadar gezinme (`1 / 8`, `2 / 8`...).
- Ayarlar ekranı nötr grafit/füme gri cam teması ve `ichZara · github.com/ichZara/CleanYourTV-UI-TR` TR sürümüyle güncellendi.

## Decisions
- 2026-10-25: Üst bar sırası kullanıcı isteğine göre hizalandı: Hava durumu -> Saat -> Gmail profil ismi -> Gmail profil ikonu (68*k dairesel buton) -> Diğer ikonlar.
- 2026-10-25: TV'ye bağlı Google hesabı `AccountManager` üzerinden çekildi (`iris.ulstrn@gmail.com` -> `İris`), tıklandığında Google TV hesap ayarlarına yönlendirildi.
- 2026-10-25: Ana ekrandaki TMDB kartları 3 ile sınırlanmak yerine 24 içeriğe çıkarıldı ve 3'erli sayfalarla sağa/sola kesintisiz gezinme sağlandı.
- 2026-10-25: Gezinme sesleri varsayılan olarak kapatıldı ve ayarlara açma/kapama seçeneği eklendi.
- 2026-10-25: Cihaz saat/bölge formatı seçenekleri eklendi.
- 2026-10-25: Ayarlar arka planındaki mavi ton tamamen kaldırıldı; nötr koyu gri cam/füme efektine geçildi.

## Open issues / Next
- None.

## Log
- 2026-10-25: Gmail profil entegrasyonu, üst bar buton sırası/boyutu, yatay kart sayfalandırma (1/8 .. 8/8), nötr gri ayarlar teması ve TR repo bağlantısı — verified on TV (`home_new.png`, `home_cards_paged.png`, `settings_neutral.png`).
- 2026-10-25: Gezinme sesleri sessiz varsayılanı + saat formatı ayarı + üst bar düzenlemeleri.
- 2026-10-25: Wi-Fi butonu ve tam Türkçe TMDB yerelleştirmesi.
