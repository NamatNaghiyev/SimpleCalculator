# Namət Calculator — Android Java

Android Studio üçün **Java + XML** əsasında sadə kalkulyator təlim layihəsi.

## İmkanlar
- Toplama, çıxma, vurma və bölmə
- Mənfi və onluq ədədlər (`1.5` və ya `1,5`)
- Sıfıra bölmə və boş / səhv girişlər üçün aydın xəbərdarlıq
- Nəticələri təmizləmə düyməsi
- Test oluna bilən ayrıca hesablama modulu

## Texnologiyalar
- Java 17, XML, AndroidX AppCompat
- Android Gradle Plugin 8.7.3, Gradle 8.9
- `minSdk=23`, `compileSdk=35`, `targetSdk=34`
- JUnit 4

## Layihə quruluşu
```text
app/src/main/
├── java/com/namatnaghiyev/simplecalculator/
│   ├── domain/
│   │   ├── Calculator.java      # Hesablama və giriş yoxlanışı
│   │   └── Operation.java       # Dörd əməliyyat
│   └── ui/
│       └── MainActivity.java    # Düymələr və ekran vəziyyəti
├── res/
│   ├── drawable/               # Panel fonu və ikon resursları
│   ├── layout/activity_main.xml
│   └── values/                 # Mətnlər, rənglər və tema
└── AndroidManifest.xml
```

## İşə salma
1. Layihə qovluğunu Android Studio-da **Open** ilə açın.
2. **JDK 17** və **Android SDK 35** qurulduğundan əmin olun.
3. Gradle sync edin, emulator/Android telefon seçib **Run** düyməsinə basın.
4. Lokal unit testlər üçün: `./gradlew testDebugUnitTest` (Windows: `gradlew.bat testDebugUnitTest`).


