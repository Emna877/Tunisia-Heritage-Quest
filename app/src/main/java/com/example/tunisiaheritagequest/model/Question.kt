package com.example.tunisiaheritagequest.model

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

enum class Difficulty {
    EASY, MEDIUM, HARD
}

data class QuizState(
    val currentQuestionIndex: Int = 0,
    val score: Int = 0,
    val totalQuestions: Int = 0,
    val answeredQuestions: MutableMap<Int, Int> = mutableMapOf(),
    val isAnswered: Boolean = false,
    val selectedAnswer: Int? = null,
    val showFeedback: Boolean = false
)

