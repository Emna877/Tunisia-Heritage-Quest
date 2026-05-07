Tunisia Heritage Quest — Project README
========================================

Purpose
-------
This document provides a concise project overview, architecture explanation, setup & run instructions, and known issues for the Tunisia Heritage Quest Android app.

Project overview
----------------
Tunisia Heritage Quest is an image-identification quiz app built with Kotlin and Jetpack Compose. Players view a monument image and choose the correct name from four options. The project currently focuses on the Islamic Heritage category (15 questions), with a museum-style visual redesign and a clean MVVM architecture.

Architecture
------------
- Pattern: MVVM (Model-View-ViewModel)
  - Model: `Question` data class and `Difficulty` enum
  - Data: `QuestionRepository` (provides questions for categories)
  - ViewModel: `QuizViewModel` (manages quiz state via StateFlow)
  - View: Compose UI screens (Splash, Main Menu, Category Selection, Difficulty Selection, Quiz, Results)
  - Navigation: Compose Navigation via `AppNavigation` and named routes

Key source locations
--------------------
- `app/src/main/java/com/example/tunisiaheritagequest/data/QuestionRepository.kt` — all quiz content (Islamic Heritage)
- `app/src/main/java/com/example/tunisiaheritagequest/viewmodel/QuizViewModel.kt` — quiz logic and state
- `app/src/main/java/com/example/tunisiaheritagequest/ui/screens/` — Compose screens
- `app/src/main/java/com/example/tunisiaheritagequest/ui/components/HeritageDecor.kt` — reusable UI primitives (borders, cards, buttons)
- `app/src/main/java/com/example/tunisiaheritagequest/ui/theme/` — color & typography

Setup & run (developer)
-----------------------
Prerequisites:
- Android Studio (recommended) or JDK + Gradle
- Android SDK with API 24+ installed
- Emulator or device

Run in Android Studio:
1. Open the project folder in Android Studio.
2. Allow Gradle to sync.
3. Start an emulator or connect a device.
4. Run the app using the Run button.

Command-line (PowerShell):

```powershell
cd "C:\Users\Emna\AndroidStudioProjects\TunisiaHeritageQuest"
# Build and install debug APK
.\gradlew clean installDebug
# Launch the app
adb shell am start -n com.example.tunisiaheritagequest/.MainActivity
```

Build artifacts
---------------
- Debug APK: `app/build/outputs/apk/debug/app-debug.apk`

Testing
-------
Run the unit tests locally:

```powershell
.\gradlew test
```

Continuous integration note: the project includes JVM unit tests. Instrumented (androidTest) UI tests are present but require an emulator/device to run.

Known issues & notes
--------------------
- Only the **Islamic Heritage** category is populated. Other categories are placeholders labeled "Coming Soon".
- The manifest now references `@drawable/icon` as the app icon (the project includes `res/drawable/icon.jpeg`). For best results replace or generate adaptive icons in `mipmap-*` for proper launcher display on all devices.
- If you see stale UI after changes, uninstall the app from the emulator/device and reinstall (`adb uninstall com.example.tunisiaheritagequest` then `./gradlew installDebug`).
- Minor test warning observed during test compilation (non-critical): check the `QuizViewModelTest` source for a redundant instance check if you want to clean the warnings.

