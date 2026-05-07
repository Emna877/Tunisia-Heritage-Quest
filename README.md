# Tunisia Heritage Quest

Tunisia Heritage Quest is an Android quiz app built with Kotlin and Jetpack Compose.  
Players identify Tunisian heritage landmarks from images and answer multiple-choice questions.

## Features

- Quiz gameplay with image-based questions
- MVVM architecture (Model, ViewModel, Compose UI)
- Category and difficulty flow
- Results screen with score feedback

## Tech Stack

- Kotlin
- Jetpack Compose
- AndroidX Navigation
- Gradle (Kotlin DSL)

## Project Structure

- `app/src/main/java/com/example/tunisiaheritagequest/data/` — quiz data and repository
- `app/src/main/java/com/example/tunisiaheritagequest/viewmodel/` — quiz state and logic
- `app/src/main/java/com/example/tunisiaheritagequest/ui/screens/` — app screens
- `app/src/main/java/com/example/tunisiaheritagequest/ui/components/` — reusable UI components
- `app/src/main/java/com/example/tunisiaheritagequest/ui/theme/` — app theme and styling

## Getting Started

### Prerequisites

- Android Studio (recommended)
- Android SDK (API 24+)
- JDK 11+

### Run in Android Studio

1. Open `/home/runner/work/Tunisia-Heritage-Quest/Tunisia-Heritage-Quest`.
2. Let Gradle sync.
3. Start an emulator or connect a device.
4. Run the `app` configuration.

### Command Line

```bash
cd /home/runner/work/Tunisia-Heritage-Quest/Tunisia-Heritage-Quest
./gradlew assembleDebug
```

Debug APK output:

`app/build/outputs/apk/debug/app-debug.apk`

## Testing

```bash
cd /home/runner/work/Tunisia-Heritage-Quest/Tunisia-Heritage-Quest
./gradlew test
```

## Notes

- Current content is focused on the **Islamic Heritage** category.
- Additional categories are prepared for future expansion.
