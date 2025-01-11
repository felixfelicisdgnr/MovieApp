Film Projesi

Bu proje, film verilerini listeleme, arama, filtreleme ve detaylarını görüntüleme gibi özellikler sunan bir uygulamadır. Uygulama, modern yazılım geliştirme yaklaşımlarını ve araçlarını kullanarak geliştirilmiştir.

Proje Özellikleri

Film Listesi: Kullanıcılar, mevcut filmlerin listesini görüntüleyebilir.

Arama Fonksiyonu: Film adı veya diğer kriterlere göre arama yapılabilir.

Filtreleme: Tür, yıl veya puan gibi farklı kategorilere göre film filtreleme.

Film Detayları: Seçilen film hakkında detaylı bilgilere erişim.

Favorilere Ekleme: Kullanıcılar, favori filmlerini işaretleyebilir.

Responsive Tasarım: Tüm cihazlarda kullanıcı dostu bir deneyim sunar.

Kullanılan Teknolojiler

Programlama Dili: Kotlin

Framework: Android Jetpack Compose (veya ilgili framework'ler, proje içeriğine göre detaylandırılabilir)

Veritabanı: Room veya diğer SQLite tabanlı çözümler

API Entegrasyonu: TMDB API veya diğer film verisi sağlayıcı API'ler

Bağımlılık Yönetimi: Gradle

Mimari: Clean Architecture (Use Case, State, Event, Effect yaklaşımları ile)

Mimari ve Yaklaşımlar

Use Case: Uygulamanın iş kurallarını içerir. Her bir Use Case, belirli bir işlevi gerçekleştirmek üzere tasarlanmıştır ve bağımsız olarak test edilebilir.

State: Kullanıcı arayüzünün mevcut durumunu temsil eder. Ekrandaki görsel öğelerin nasıl görünmesi gerektiği bu duruma göre belirlenir.

Event: Kullanıcıdan veya sistemden gelen olayları ifade eder. Örneğin, bir butona tıklama veya veri yüklemenin tamamlanması birer Event olabilir.

Effect: Kullanıcının dikkatini çeken, genellikle tek seferlik gerçekleşen olaylardır. Örneğin, bir hata mesajı göstermek veya bir ekran geçişi gerçekleştirmek.

Kurulum ve Çalıştırma

Depoyu Klonlayın:

git clone <repository-url>

Proje Bağımlılıklarını Yükleyin:

./gradlew build

API Anahtarını Ayarlayın:

Projenin local.properties dosyasına aşağıdaki satırı ekleyin:

API_KEY=<Sizin_TMDB_API_Anahtarınız>

Uygulamayı Çalıştırın:

Android Studio veya terminal kullanarak uygulamayı bir emulator veya fiziksel cihazda başlatın.

Katkıda Bulunma

Bu projeyi fork edin.

Yeni bir dal oluşturun: git checkout -b yeni-ozellik

Yaptığınız değişiklikleri commit edin: git commit -m 'Yeni bir özellik ekle'

Dalınızı push edin: git push origin yeni-ozellik

Bir pull request oluşturun.

Lisans

Bu proje MIT Lisansı ile lisanslanmıştır. Daha fazla bilgi için LICENSE dosyasına göz atabilirsiniz.

Herhangi bir sorunuz veya öneriniz varsa, lütfen bizimle iletişime geçmekten çekinmeyin!

![WhatsApp Image 2025-01-11 at 5 31 14 PM](https://github.com/user-attachments/assets/c93d3705-721b-4f52-960e-5ff0019105e1)
![WhatsApp Image 2025-01-11 at 5 31 34 PM](https://github.com/user-attachments/assets/1fe9681c-7afb-4695-a88f-de7275997b64)
![WhatsApp Image 2025-01-11 at 5 31 53 PM](https://github.com/user-attachments/assets/c9b663fb-a8f8-4d06-beb1-1cd5aa12ef91)
![WhatsApp Image 2025-01-11 at 5 32 22 PM](https://github.com/user-attachments/assets/fef57ad1-b26c-4ede-86ff-b14adb5f8601)
