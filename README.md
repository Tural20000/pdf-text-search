📄 PDFTextSearch — Full-Text Search Engine
PDFTextSearch, Spring Boot və Elasticsearch istifadə edərək hazırlanmış, PDF sənədlərinin daxilində tam mətnli axtarış (Full-text search) imkanı verən yüksək performanslı bir backend xidmətidir.

🚀 Texnologiya Steki
Java 21 / Spring Boot 3.4.2

Elasticsearch — Sürətli və miqyaslana bilən axtarış mühərriki.

Apache Tika — PDF sənədlərindən mətnin çıxarılması (Content Extraction).

Spring Data Elasticsearch — Verilənlər bazası inteqrasiyası.

Lombok — Təmiz və oxunaqlı kod strukturu.

Asinxron Emal (@Async) — Böyük faylların arxa planda indekslənməsi.

✨ Xüsusiyyətlər
✅ PDF Yükləmə: Faylların unikal UUID ilə qovluq sistemində saxlanılması.

✅ Mətn Çıxarışı: Apache Tika vasitəsilə mürəkkəb PDF-lərdən mətnlərin oxunması.

✅ Sürətli Axtarış: Elasticsearch "Match Query" ilə milyonlarla sətir arasında anlıq axtarış.

✅ Pagination: Axtarış nəticələrinin səhifələnmiş formada (Pageable) təqdim edilməsi.

✅ Xəta İdarəetməsi: Global Exception Handler ilə mərkəzləşdirilmiş xəta mesajları.

🛠️ Quraşdırma (Setup)
Elasticsearch-i işə salın: (Docker və ya lokal olaraq localhost:9200).

application.properties tənzimləməsi:

Properties
app.upload.dir=C:/your/path/uploads
spring.elasticsearch.uris=http://localhost:9200
Layihəni işə salın: mvn spring-boot:run

🔌 API Endpoint-ləri
1. Fayl Yükləmə
URL: POST /api/pdf/upload

Body (form-data): file: [PDF_FAYL]

Açıqlama: Faylı diskə yazır və asinxron olaraq Elasticsearch-ə indeksləyir.

2. Məzmun Axtarışı
URL: GET /api/pdf/search?query=açar_söz&page=0&size=10

Açıqlama: Sənədlərin tərkibində axtarış edir və səhifələnmiş nəticə qaytarır.

👨‍💻 Müəllif
Tural Abdullayev
Java Backend Developer | Spring Boot Enthusiast