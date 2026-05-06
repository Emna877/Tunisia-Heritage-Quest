# Tunisia Heritage Quest - Features Documentation

## 🎮 Gameplay Features

### 1. Multiple Choice Quiz System
- **4-option questions** for each monument
- **Instant feedback** after answer selection
- **Correct answer display** when user is wrong
- **Key facts** shown for educational value
- **Next/Skip buttons** after feedback
- **Question counter** showing progress (e.g., "Question 1 of 5")

### 2. Difficulty System
Three difficulty levels with different question sets:

#### Easy Mode (5 Questions)
- Basic identification questions
- Most famous monuments
- Clear distinctive features

#### Medium Mode (5 Questions)
- More detailed questions
- Architectural features focus
- Historical context required

#### Hard Mode (4 Questions)
- Complex architectural styles
- Deep historical knowledge
- Comparative questions

**Implementation**: Questions stored by difficulty in `QuestionRepository`

### 3. Scoring System
- **Per-question basis**: 1 point per correct answer
- **Percentage calculation**: (Correct Answers / Total Questions) × 100
- **Performance tiers**:
  - 80%+ : "Excellent! You are a heritage expert!"
  - 60-79% : "Good job! Keep exploring Tunisian heritage."
  - 40-59% : "Average. Learn more about these monuments."
  - <40% : "Keep learning! Try again with difficulty level."

**Features**:
- Real-time score tracking
- Final percentage display
- Correct answer count
- Performance message feedback

### 4. Timer System
- **Optional 15-second countdown** per question
- **Enable/disable toggle** in settings
- **Visual feedback**:
  - Normal color: Time remaining
  - Red highlight: < 5 seconds
- **Auto-skip on timeout**: Question automatically skipped if timer reaches 0
- **Timer pause**: Stops when answer is selected and feedback shown
- **Timer reset**: Resets to 15 seconds for each new question

**Implementation**: Uses `LaunchedEffect` with coroutine delays

### 5. Progress Tracking

#### During Quiz
- Question counter (e.g., "Question 3 of 14")
- Visual progress indication
- Location badge showing monument location
- Timer display when enabled

#### After Quiz
- Final score percentage (large display)
- Correct answers count (e.g., "Correct: 10/14")
- Performance message
- Comparison with difficulty level

### 6. Instant Feedback System

When answer is selected:
1. **Immediate Response**:
   - Green highlight: Correct answer
   - Red highlight: Incorrect answer

2. **Feedback Display**:
   - "Correct!" or "Incorrect!" label
   - If wrong: Shows the correct answer
   - Key fact about the monument displayed
   - All disabled except next button

3. **Navigation**:
   - Skip button (available after feedback)
   - Submit/Next button (available after feedback)

### 7. Image Identification
- **High-quality images** for all 14 monuments
- **Image placement**: Card-based layout above questions
- **Aspect ratio**: Optimized for different screen sizes
- **Content scale**: Crop to fill while maintaining quality

**Images included**:
- great_mosque_of_kairouan.jpg
- zitouna_mosque.jpg
- sidi_sahbi_mosque.jpg
- mosque_of_the_three_doors.jpg
- great_mosque_of_sfax.jpg
- great_mosque_of_testour.jpeg
- kasbah_mosque.jpg
- youssef_dey_mosque.jpg
- hammouda_pasha_mosque.jpg
- sidi_bou_makhlouf_mosque.jpg (zaouia_of_sidi_bou_makhlouf.jpg)
- sidi_mahrez_mosque.jpg
- zaouia_of_sidi_ben_arous.jpg
- zaouia_of_sidi_bou_said.jpg
- great_mosque_of_mahdia.jpg

---

## 🏛️ Content Features

### Islamic Heritage Monuments (14 Total)

#### Kairouan Monuments (3)
1. **Great Mosque of Kairouan**
   - Founded: 670 AD
   - Fact: Oldest Muslim place of worship in Maghreb
   - Significance: Major center of early Islamic scholarship

2. **Sidi Sahbi Mosque**
   - Also Known As: "Barber's Mosque"
   - Contains: Tomb of a companion of Prophet Muhammad
   - Significance: Important spiritual site

3. **Mosque of the Three Doors**
   - Famous For: Intricately carved Kufic inscriptions on façade
   - Significance: Architectural masterpiece

#### Tunis Monuments (5)
4. **Zitouna Mosque**
   - Location: Medina
   - Founded: Early Islamic period
   - Fact: One of oldest universities in Islamic world
   - Significance: Center of learning for over a millennium

5. **Kasbah Mosque**
   - Period: 13th century
   - Builders: Almohads
   - Location: Near government square
   - Significance: Seat of power mosque

6. **Youssef Dey Mosque**
   - Built: 1616
   - Distinction: First Ottoman-style mosque in Tunisia
   - Significance: Ottoman architectural influence

7. **Hammouda Pasha Mosque**
   - Special Feature: Octagonal minaret
   - Rarity: Rare in Tunisian mosque architecture
   - Period: Ottoman era

8. **Sidi Mahrez Mosque**
   - Architecture: Ottoman style
   - Comparison: Similar to Istanbul mosques
   - Significance: Eastern Mediterranean influence

#### Other Regional Monuments (6)
9. **Great Mosque of Sfax**
   - Built: 9th century
   - Style: Fortress-like architecture
   - Significance: Unique defensive style

10. **Great Mosque of Testour**
    - Built By: Andalusian refugees
    - Unique Feature: Clock runs counterclockwise
    - Significance: Cultural heritage site

11. **Zaouia of Sidi Ben Arous** (Tunis)
    - Dedicated To: Revered Sufi saint
    - Purpose: Spiritual site
    - Type: Sufi sanctuary

12. **Zaouia of Sidi Bou Said** (Sidi Bou Said)
    - Shrine Of: Saint who gave village its name
    - Significance: Important pilgrimage site

13. **Sidi Bou Makhlouf Mosque** (El Kef)
    - Distinguished By: Unique façade
    - Influence: Andalusian architecture
    - Significance: Cultural heritage

14. **Great Mosque of Mahdia**
    - Built By: Fatimids
    - Notable Feature: Lacks traditional minaret
    - Significance: Unique architectural approach

---

## 🎨 UI/UX Features

### Screen Features

#### Splash Screen
- 3-second auto-transition
- Elegant branding
- Mediterranean blue background
- App title and subtitle

#### Main Menu
- "Start Quiz" button
- Clean, minimalist design
- Warm beige background
- Centered layout

#### Category Selection
- Islamic Heritage category button
- Category description
- Back to main menu option
- Visual category representation

#### Difficulty Selection
- Three difficulty buttons (Easy/Medium/Hard)
- Visual selection feedback (color change)
- Timer enable checkbox
- 15-second timer label
- Start Quiz and Back buttons

#### Quiz Screen
- Monument image (250dp height)
- Question text (centered, bold)
- Location badge (location info)
- Four answer buttons
- Timer display (when enabled)
- Question counter (top header)
- Skip and Submit buttons

#### Results Screen
- "Quiz Completed!" title
- Large score percentage display
- Correct answers count
- Performance message card
- Color-coded feedback (by score)
- Play Again button
- Main Menu button

### Interactive Elements

#### Buttons
- Material Design elevation
- Color-coded by purpose
- Hover effects
- Disabled state during feedback

#### Cards
- Elevation for depth
- Rounded corners
- Color-coded backgrounds
- Padding for content

#### Text
- Hierarchy: Title > Subtitle > Body
- Color-coded by context
- Readable font sizes
- Proper spacing

---

## 🌍 Responsive Design

### Screen Size Adaptation
- **Phone screens**: Full-width layouts
- **Tablet screens**: Wider content with maintained aspect ratios
- **Landscape mode**: Horizontal layouts
- **Portrait mode**: Vertical layouts

### Responsive Components
- `fillMaxWidth()`: Adapts to screen width
- `fillMaxSize()`: Full screen utilization
- `padding()`: Dynamic spacing
- `weight()`: Proportional sizing
- `modifier` chains: Flexible layouts

---

## 🔒 State Management Features

### Quiz State Persistence
- Current question saved
- Score maintained
- Answered questions tracked
- Timer state preserved

### Configuration Change Handling
- ViewModel survives rotation
- State restored automatically
- No data loss on device flip

### State Features
- Score accumulation
- Question progression
- Answer validation
- Feedback timing

---

## 🎯 Navigation Features

### Route System
- Splash Screen start
- Main Menu as hub
- Category selection flow
- Difficulty configuration
- Quiz gameplay
- Results display

### Back Navigation
- Proper back stack management
- Category → Main Menu
- Difficulty → Category
- Results → Menu or Replay

### State Clearing
- Menu navigation clears quiz state
- Reset on replay
- Clean transitions

---

## 📊 Data Features

### Question Structure
```kotlin
data class Question(
    val id: Int,
    val imageResId: Int,
    val text: String,
    val options: List<String>,
    val correctAnswerIndex: Int,
    val keyFact: String,
    val difficulty: Difficulty,
    val location: String
)
```

### Repository Pattern
- Centralized question source
- Easy to extend with more categories
- Maintainable question data
- Question filtering by difficulty

---

## ⚡ Performance Features

### Optimization
- Lazy question loading
- Efficient image handling
- Minimal recomposition
- Memory-conscious design

### Resource Management
- Timer cleanup
- State cleanup
- Image resource optimization
- No memory leaks

---

## 🧪 Testing Features

### Unit Tests
- ViewModel initialization
- Question data validation
- Difficulty separation
- State management

### UI Tests
- Component rendering
- Navigation flows
- User interactions
- Screen display

### Test Coverage
- Model tests: Question integrity
- ViewModel tests: State management
- Navigation tests: Flow validation
- Compose tests: UI rendering

---

## 📱 Accessibility Features

### Visual
- Clear color contrast
- Large readable fonts
- Proper spacing
- Visual feedback

### Interaction
- Large button targets
- Clear labels
- Descriptive text
- Intuitive flow

---

## 🎓 Educational Features

### Learning Content
- Historical facts (key facts)
- Geographic information
- Architectural details
- Cultural significance

### Educational Presentation
- Image-based identification
- Multiple choice reinforcement
- Feedback-based learning
- Difficulty progression

---

## 🌟 User Experience Features

### Visual Feedback
- Color-coded answers
- Score display
- Progress indication
- Status messages

### Performance Messages
- Customized by score
- Encouraging feedback
- Actionable suggestions
- Motivational text

### Replay Features
- Play Again option
- Different difficulty choice
- Menu return option
- Reset functionality

---

## Summary

Tunisia Heritage Quest provides a comprehensive, engaging platform for learning about Islamic heritage in Tunisia through gamified education. All features are implemented, tested, and working correctly.

**Total Features**: 40+
**Complexity Level**: Intermediate-Advanced
**User Engagement**: High through immediate feedback and progression

