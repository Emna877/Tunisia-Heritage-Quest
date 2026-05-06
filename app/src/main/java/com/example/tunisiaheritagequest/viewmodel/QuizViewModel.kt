package com.example.tunisiaheritagequest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tunisiaheritagequest.data.QuestionRepository
import com.example.tunisiaheritagequest.model.Difficulty
import com.example.tunisiaheritagequest.model.Question
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class QuizViewModel : ViewModel() {
    
    private val _questions = MutableStateFlow<List<Question>>(emptyList())
    val questions: StateFlow<List<Question>> = _questions.asStateFlow()
    
    private val _currentQuestionIndex = MutableStateFlow(0)
    val currentQuestionIndex: StateFlow<Int> = _currentQuestionIndex.asStateFlow()
    
    private val _selectedAnswerIndex = MutableStateFlow<Int?>(null)
    val selectedAnswerIndex: StateFlow<Int?> = _selectedAnswerIndex.asStateFlow()
    
    private val _score = MutableStateFlow(0)
    val score: StateFlow<Int> = _score.asStateFlow()
    
    private val _answeredQuestions = MutableStateFlow<Set<Int>>(emptySet())
    val answeredQuestions: StateFlow<Set<Int>> = _answeredQuestions.asStateFlow()
    
    private val _showFeedback = MutableStateFlow(false)
    val showFeedback: StateFlow<Boolean> = _showFeedback.asStateFlow()
    
    private val _quizEnded = MutableStateFlow(false)
    val quizEnded: StateFlow<Boolean> = _quizEnded.asStateFlow()
    
    private val _selectedDifficulty = MutableStateFlow(Difficulty.EASY)
    val selectedDifficulty: StateFlow<Difficulty> = _selectedDifficulty.asStateFlow()
    
    private val _timerEnabled = MutableStateFlow(false)
    val timerEnabled: StateFlow<Boolean> = _timerEnabled.asStateFlow()
    
    private val _timeRemaining = MutableStateFlow(15)
    val timeRemaining: StateFlow<Int> = _timeRemaining.asStateFlow()

    fun initializeQuiz(difficulty: Difficulty, timerEnabled: Boolean) {
        viewModelScope.launch {
            _selectedDifficulty.value = difficulty
            _timerEnabled.value = timerEnabled
            
            val allQuestions = QuestionRepository.getIslamicHeritageQuestions()
            _questions.value = allQuestions.filter { it.difficulty == difficulty }.shuffled()
            
            _currentQuestionIndex.value = 0
            _score.value = 0
            _answeredQuestions.value = emptySet()
            _showFeedback.value = false
            _quizEnded.value = false
            _selectedAnswerIndex.value = null
            _timeRemaining.value = 15
        }
    }
    
    fun selectAnswer(index: Int) {
        viewModelScope.launch {
            if (_selectedAnswerIndex.value == null) {
                _selectedAnswerIndex.value = index
                _showFeedback.value = true
                
                val currentQuestion = _questions.value.getOrNull(_currentQuestionIndex.value)
                if (currentQuestion != null && index == currentQuestion.correctAnswerIndex) {
                    _score.value = _score.value + 1
                }
                
                val updated = _answeredQuestions.value.toMutableSet()
                updated.add(_currentQuestionIndex.value)
                _answeredQuestions.value = updated
            }
        }
    }
    
    fun nextQuestion() {
        viewModelScope.launch {
            if (_currentQuestionIndex.value < _questions.value.size - 1) {
                _currentQuestionIndex.value = _currentQuestionIndex.value + 1
                _selectedAnswerIndex.value = null
                _showFeedback.value = false
                _timeRemaining.value = 15
            } else {
                _quizEnded.value = true
            }
        }
    }
    
    fun skipQuestion() {
        viewModelScope.launch {
            if (_currentQuestionIndex.value < _questions.value.size - 1) {
                _currentQuestionIndex.value = _currentQuestionIndex.value + 1
                _selectedAnswerIndex.value = null
                _showFeedback.value = false
                _timeRemaining.value = 15
            } else {
                _quizEnded.value = true
            }
        }
    }
    
    fun updateTimeRemaining(remaining: Int) {
        viewModelScope.launch {
            _timeRemaining.value = remaining
            if (remaining <= 0 && _selectedAnswerIndex.value == null) {
                skipQuestion()
            }
        }
    }
    
    fun resetQuiz() {
        viewModelScope.launch {
            _currentQuestionIndex.value = 0
            _selectedAnswerIndex.value = null
            _score.value = 0
            _answeredQuestions.value = emptySet()
            _showFeedback.value = false
            _quizEnded.value = false
            _questions.value = emptyList()
        }
    }
}

