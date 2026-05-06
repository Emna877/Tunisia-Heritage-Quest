package com.example.tunisiaheritagequest

import com.example.tunisiaheritagequest.data.QuestionRepository
import com.example.tunisiaheritagequest.model.Difficulty
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class QuestionModelTest {

    @Test
    fun testQuestionRepositoryLoadsAllQuestions() {
        val questions = QuestionRepository.getIslamicHeritageQuestions()
        
        assertTrue(questions.isNotEmpty())
        assertEquals(15, questions.size)
    }

    @Test
    fun testAllQuestionsHaveDifficulty() {
        val questions = QuestionRepository.getIslamicHeritageQuestions()
        
        for (question in questions) {
            assertNotNull(question.difficulty)
            assertTrue(
                question.difficulty == Difficulty.EASY ||
                question.difficulty == Difficulty.MEDIUM ||
                question.difficulty == Difficulty.HARD
            )
        }
    }

    @Test
    fun testAllQuestionsHaveFourOptions() {
        val questions = QuestionRepository.getIslamicHeritageQuestions()
        
        for (question in questions) {
            assertEquals(4, question.options.size)
        }
    }

    @Test
    fun testCorrectAnswerIndexIsValid() {
        val questions = QuestionRepository.getIslamicHeritageQuestions()
        
        for (question in questions) {
            assertTrue(question.correctAnswerIndex >= 0)
            assertTrue(question.correctAnswerIndex < question.options.size)
        }
    }

    @Test
    fun testAllQuestionsHaveKeyFact() {
        val questions = QuestionRepository.getIslamicHeritageQuestions()
        
        for (question in questions) {
            assertFalse(question.keyFact.isEmpty())
        }
    }

    @Test
    fun testAllQuestionsHaveLocation() {
        val questions = QuestionRepository.getIslamicHeritageQuestions()
        
        for (question in questions) {
            assertFalse(question.location.isEmpty())
        }
    }

    @Test
    fun testEasyDifficultySetsCorrect() {
        val questions = QuestionRepository.getIslamicHeritageQuestions()
        val easyQuestions = questions.filter { it.difficulty == Difficulty.EASY }
        
        assertTrue(easyQuestions.isNotEmpty())
        assertEquals(5, easyQuestions.size)
    }

    @Test
    fun testMediumDifficultySetsCorrect() {
        val questions = QuestionRepository.getIslamicHeritageQuestions()
        val mediumQuestions = questions.filter { it.difficulty == Difficulty.MEDIUM }
        
        assertTrue(mediumQuestions.isNotEmpty())
        assertEquals(5, mediumQuestions.size)
    }

    @Test
    fun testHardDifficultySetsCorrect() {
        val questions = QuestionRepository.getIslamicHeritageQuestions()
        val hardQuestions = questions.filter { it.difficulty == Difficulty.HARD }
        
        assertTrue(hardQuestions.isNotEmpty())
        assertEquals(5, hardQuestions.size)
    }
}

