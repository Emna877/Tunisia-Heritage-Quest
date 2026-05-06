# Architecture & Lifecycle Documentation

## Architecture Components

### 1. MVVM Architecture Pattern

The application follows the Model-View-ViewModel (MVVM) architectural pattern:

#### Model Layer (`model/`)
- **Question.kt**: Data classes representing questions and quiz state
  - `Question`: Contains question data (image, text, options, correct answer, key fact, difficulty, location)
  - `Difficulty`: Enum for difficulty levels (EASY, MEDIUM, HARD)
  - `QuizState`: State holder for quiz progress

#### View Layer (`ui/`)
- **Screens**: Compose UI components for each app screen
  - SplashScreen: Initial app branding
  - MainMenuScreen: Entry point with start button
  - CategorySelectionScreen: Category picker
  - DifficultySelectionScreen: Difficulty and timer settings
  - QuizScreen: Main gameplay interface
  - ResultsScreen: Final score and feedback

#### ViewModel Layer (`viewmodel/`)
- **QuizViewModel**: Central state management
  - Manages quiz state using StateFlow
  - Handles question progression
  - Tracks score and answers
  - Controls timer

#### Data Layer (`data/`)
- **QuestionRepository**: Singleton providing all questions
  - 14 Islamic Heritage questions
  - Organized by difficulty (5 Easy, 5 Medium, 4 Hard)

### 2. Navigation Architecture

Uses Jetpack Compose Navigation for type-safe routing:

```
Splash Screen
    ↓
Main Menu
    ↓
Category Selection
    ↓
Difficulty Selection
    ↓
Quiz Gameplay
    ↓
Results Screen
```

Routes defined in `Routes` object:
- SPLASH: "splash"
- MAIN_MENU: "main_menu"
- CATEGORY_SELECTION: "category_selection"
- DIFFICULTY_SELECTION: "difficulty_selection"
- QUIZ: "quiz"
- RESULTS: "results"

### 3. State Management

**QuizViewModel** manages all quiz state via StateFlow:
- `currentQuestionIndex`: Current question position
- `score`: Number of correct answers
- `selectedAnswerIndex`: User's selected option
- `showFeedback`: Display feedback state
- `quizEnded`: Quiz completion flag
- `timerEnabled`: Timer on/off toggle
- `timeRemaining`: Countdown timer value

## Activity Lifecycle Implementation

### MainActivity Lifecycle Methods

```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()  // Enable edge-to-edge display
        setContent {
            TunisiaHeritageQuestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    AppContent()  // Set Compose content
                }
            }
        }
    }
}
```

### Lifecycle Stages

1. **Creation** (onCreate)
   - Activity created
   - Compose content set
   - Theme applied
   - Navigation initialized

2. **Start** (onStart)
   - Activity becomes visible
   - UI elements prepared
   - Compose recomposition triggered

3. **Resume** (onResume)
   - Activity becomes foreground
   - User can interact
   - Timer can start
   - Navigation becomes active

4. **Pause** (onPause)
   - Activity loses focus
   - Timer should pause
   - Animations can stop
   - State should be preserved

5. **Stop** (onStop)
   - Activity no longer visible
   - Resource cleanup begins
   - Can save state

6. **Destroy** (onDestroy)
   - Activity being destroyed
   - All resources cleaned
   - ViewModel cleared

### ViewModel Lifecycle

The QuizViewModel is created by Compose and persists across configuration changes:

```kotlin
@Composable
fun AppNavigation(navController: NavHostController) {
    val quizViewModel: QuizViewModel = viewModel()  // ViewModel lifecycle
    // ViewModel survives rotation and other config changes
}
```

**State Preservation**:
- Quiz progress saved in ViewModel (survived rotations)
- Current question index persisted
- Score maintained across screens
- Timer state preserved

## State Flow & Reactivity

All mutable state uses StateFlow for reactive updates:

```kotlin
private val _score = MutableStateFlow(0)
val score: StateFlow<Int> = _score.asStateFlow()

// Collect state in UI
val score by viewModel.score.collectAsState()
```

Benefits:
- Reactive UI updates
- Thread-safe state changes
- Easy testing
- Coroutine-based

## Timer Implementation

The quiz includes an optional 15-second timer:

```kotlin
LaunchedEffect(showFeedback, timerEnabled, timeRemaining) {
    if (timerEnabled && !showFeedback && timeRemaining > 0) {
        delay(1000)
        viewModel.updateTimeRemaining(timeRemaining - 1)
    }
}
```

**Lifecycle Integration**:
- Timer starts when question displays
- Pauses when answer selected (showFeedback = true)
- Auto-skips question when reaching 0
- Resets on question change

## Compose Lifecycle

### Recomposition
- **Minimal recompositions**: Only affected composables recompose
- **StateFlow collection**: Triggers recomposition on state change
- **Key-based stability**: Navigation handles proper scoping

### LaunchedEffect
Used for side effects:
- Splash screen auto-navigation (3 second delay)
- Timer countdown
- Quiz completion auto-navigation

### Composition Locals
- Navigation controller passed through composition
- Theme available throughout app

## Error Handling & State Recovery

1. **Quiz State Reset**: `resetQuiz()` clears all state for new game
2. **Navigation Back Stack**: Proper pop-up behavior
3. **State Validation**: All questions validated before use
4. **Bounds Checking**: Index validation before access

## Testing Architecture

### Unit Tests (Local)
- Quick execution (no device needed)
- Test ViewModel state initialization
- Test data validation
- Test business logic

### Instrumented Tests (Device)
- Navigation flow testing
- UI component testing
- Compose rendering validation

## Performance Considerations

1. **Lazy Loading**: Questions loaded only when needed
2. **Image Handling**: Images loaded from drawable resources
3. **Coroutine Scoping**: Proper cancellation with viewModelScope
4. **Compose Efficiency**: Efficient recomposition strategy

## Resource Management

1. **Memory**: 
   - ViewModel cleared on app exit
   - Compose recomposition optimized
   - No memory leaks from timers

2. **CPU**:
   - Timer only runs during quiz
   - Animations use GPU
   - Efficient Compose layout

3. **Battery**:
   - Background timer stopped
   - Screen optimization with Material Design
   - Efficient recomposition

## Configuration Changes

The app handles rotation and other configuration changes:
- ViewModel survives configuration changes
- Quiz state preserved
- Navigation maintained
- UI adapts to new dimensions

```kotlin
// Automatic through ViewModel lifecycle
val quizViewModel: QuizViewModel = viewModel()
// Persists across rotation
```

## Data Flow Diagram

```
User Input (Screen)
        ↓
Compose UI Event Handler
        ↓
ViewModel Method (e.g., selectAnswer)
        ↓
StateFlow Update
        ↓
Recompose Affected UI
        ↓
Display Updated Screen
```

## Future Enhancements

### Lifecycle Extensions
- Save quiz progress to database
- Restore incomplete quizzes
- Statistics tracking across sessions

### Architecture Improvements
- Add Room database for persistence
- Implement offline-first approach
- Add analytics tracking

### State Management
- Add Redux-like architecture for complex state
- Implement undo/redo functionality
- Add quiz history tracking

