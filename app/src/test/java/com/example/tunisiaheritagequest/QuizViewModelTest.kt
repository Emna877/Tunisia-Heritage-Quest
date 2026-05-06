package com.example.tunisiaheritagequest

import com.example.tunisiaheritagequest.model.Difficulty
import com.example.tunisiaheritagequest.viewmodel.QuizViewModel
import org.junit.Assert.assertEquals
import org.junit.Test

class QuizViewModelTest {

    @Test
    fun testQuizViewModelCanBeCreated() {
        val viewModel = QuizViewModel()
        assert(viewModel is QuizViewModel)
    }

    @Test
    fun testInitialScoreIsZero() {
        val viewModel = QuizViewModel()
        assertEquals(0, viewModel.score.value)
    }

    @Test
    fun testInitialCurrentQuestionIndexIsZero() {
        val viewModel = QuizViewModel()
        assertEquals(0, viewModel.currentQuestionIndex.value)
    }

    @Test
    fun testInitialSelectedAnswerIsNull() {
        val viewModel = QuizViewModel()
        assertEquals(null, viewModel.selectedAnswerIndex.value)
    }

    @Test
    fun testQuizNotEndedInitially() {
        val viewModel = QuizViewModel()
        assertEquals(false, viewModel.quizEnded.value)
    }

    @Test
    fun testDifficultyCanBeSet() {
        val viewModel = QuizViewModel()
        assertEquals(Difficulty.EASY, viewModel.selectedDifficulty.value)
    }

    @Test
    fun testTimerDisabledByDefault() {
        val viewModel = QuizViewModel()
        assertEquals(false, viewModel.timerEnabled.value)
    }

    @Test
    fun testTimeRemainingInitiallyFifteen() {
        val viewModel = QuizViewModel()
        assertEquals(15, viewModel.timeRemaining.value)
    }
}


