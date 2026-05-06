package com.example.tunisiaheritagequest.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tunisiaheritagequest.model.Difficulty
import com.example.tunisiaheritagequest.ui.screens.CategorySelectionScreen
import com.example.tunisiaheritagequest.ui.screens.DifficultySelectionScreen
import com.example.tunisiaheritagequest.ui.screens.MainMenuScreen
import com.example.tunisiaheritagequest.ui.screens.QuizScreen
import com.example.tunisiaheritagequest.ui.screens.ResultsScreen
import com.example.tunisiaheritagequest.ui.screens.SplashScreen
import com.example.tunisiaheritagequest.viewmodel.QuizViewModel

object Routes {
    const val SPLASH = "splash"
    const val MAIN_MENU = "main_menu"
    const val CATEGORY_SELECTION = "category_selection"
    const val DIFFICULTY_SELECTION = "difficulty_selection"
    const val QUIZ = "quiz"
    const val RESULTS = "results"
}

@Composable
fun AppNavigation(navController: NavHostController) {
    val quizViewModel: QuizViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH
    ) {
        composable(Routes.SPLASH) {
            SplashScreen(
                onSplashComplete = {
                    navController.navigate(Routes.MAIN_MENU) {
                        popUpTo(Routes.SPLASH) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.MAIN_MENU) {
            MainMenuScreen(
                onStartClick = {
                    navController.navigate(Routes.CATEGORY_SELECTION)
                }
            )
        }

        composable(Routes.CATEGORY_SELECTION) {
            CategorySelectionScreen(
                onCategorySelected = {
                    navController.navigate(Routes.DIFFICULTY_SELECTION)
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(Routes.DIFFICULTY_SELECTION) {
            DifficultySelectionScreen(
                onDifficultySelected = { difficulty, timerEnabled ->
                    quizViewModel.initializeQuiz(difficulty, timerEnabled)
                    navController.navigate(Routes.QUIZ) {
                        popUpTo(Routes.CATEGORY_SELECTION) { inclusive = true }
                    }
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(Routes.QUIZ) {
            QuizScreen(
                viewModel = quizViewModel,
                onQuizCompleted = {
                    navController.navigate(Routes.RESULTS) {
                        popUpTo(Routes.DIFFICULTY_SELECTION) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.RESULTS) {
            val scoreState = quizViewModel.score.collectAsState()
            val questionsState = quizViewModel.questions.collectAsState()

            ResultsScreen(
                score = scoreState.value,
                totalQuestions = questionsState.value.size,
                onPlayAgain = {
                    quizViewModel.resetQuiz()
                    navController.navigate(Routes.DIFFICULTY_SELECTION) {
                        popUpTo(Routes.MAIN_MENU) { inclusive = true }
                    }
                },
                onMainMenu = {
                    quizViewModel.resetQuiz()
                    navController.navigate(Routes.MAIN_MENU) {
                        popUpTo(Routes.SPLASH) { inclusive = true }
                    }
                }
            )
        }
    }
}

