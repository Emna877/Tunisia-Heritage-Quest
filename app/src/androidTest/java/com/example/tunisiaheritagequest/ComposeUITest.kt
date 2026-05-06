package com.example.tunisiaheritagequest

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.tunisiaheritagequest.ui.screens.MainMenuScreen
import com.example.tunisiaheritagequest.ui.theme.TunisiaHeritageQuestTheme
import org.junit.Rule
import org.junit.Test

class ComposeUITest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testMainMenuScreenDisplaysStartButton() {
        composeTestRule.setContent {
            TunisiaHeritageQuestTheme {
                MainMenuScreen(onStartClick = {})
            }
        }

        composeTestRule.onNodeWithText("Start Quiz").assertIsDisplayed()
    }

    @Test
    fun testMainMenuScreenDisplaysTitle() {
        composeTestRule.setContent {
            TunisiaHeritageQuestTheme {
                MainMenuScreen(onStartClick = {})
            }
        }

        composeTestRule.onNodeWithText("Tunisia Heritage Quest").assertIsDisplayed()
    }
}

