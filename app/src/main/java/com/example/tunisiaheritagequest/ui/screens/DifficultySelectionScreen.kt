package com.example.tunisiaheritagequest.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tunisiaheritagequest.R
import com.example.tunisiaheritagequest.model.Difficulty
import com.example.tunisiaheritagequest.ui.components.HeritageCard
import com.example.tunisiaheritagequest.ui.components.HeritageDivider
import com.example.tunisiaheritagequest.ui.components.HeritagePatternBorder
import com.example.tunisiaheritagequest.ui.theme.DeepBlue
import com.example.tunisiaheritagequest.ui.theme.GoldAccent
import com.example.tunisiaheritagequest.ui.theme.LightSandBeige
import com.example.tunisiaheritagequest.ui.theme.SandBeige

@Composable
fun DifficultySelectionScreen(
    onDifficultySelected: (Difficulty, Boolean) -> Unit,
    onBack: () -> Unit
) {
    var selectedDifficulty by remember { mutableStateOf(Difficulty.EASY) }
    var timerEnabled by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(LightSandBeige, SandBeige.copy(alpha = 0.7f))
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        HeritagePatternBorder()

        HeritageCard(
            modifier = Modifier
                .fillMaxWidth(0.92f)
                .padding(horizontal = 16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = stringResource(R.string.select_difficulty),
                    style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold),
                    color = DeepBlue
                )

                HeritageDivider()

                DifficultyButton(
                    label = stringResource(R.string.difficulty_easy),
                    isSelected = selectedDifficulty == Difficulty.EASY,
                    onClick = { selectedDifficulty = Difficulty.EASY }
                )

                DifficultyButton(
                    label = stringResource(R.string.difficulty_medium),
                    isSelected = selectedDifficulty == Difficulty.MEDIUM,
                    onClick = { selectedDifficulty = Difficulty.MEDIUM }
                )

                DifficultyButton(
                    label = stringResource(R.string.difficulty_hard),
                    isSelected = selectedDifficulty == Difficulty.HARD,
                    onClick = { selectedDifficulty = Difficulty.HARD }
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = timerEnabled,
                        onCheckedChange = { timerEnabled = it },
                        colors = CheckboxDefaults.colors(
                            checkedColor = DeepBlue,
                            checkmarkColor = Color.White
                        )
                    )
                    Text(
                        stringResource(R.string.enable_timer),
                        modifier = Modifier.padding(start = 8.dp),
                        fontSize = 15.sp,
                        color = DeepBlue
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Button(
                        onClick = onBack,
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = DeepBlue
                        ),
                        border = androidx.compose.foundation.BorderStroke(1.dp, GoldAccent)
                    ) {
                        Text(stringResource(R.string.main_menu))
                    }

                    Button(
                        onClick = { onDifficultySelected(selectedDifficulty, timerEnabled) },
                        modifier = Modifier.weight(1.3f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = GoldAccent,
                            contentColor = DeepBlue
                        )
                    ) {
                        Text(stringResource(R.string.menu_start))
                    }
                }
            }
        }

        HeritagePatternBorder()
    }
}

@Composable
fun DifficultyButton(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth(0.82f)
            .padding(vertical = 4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) DeepBlue else Color.White,
            contentColor = if (isSelected) Color.White else DeepBlue
        )
    ) {
        Text(
            label,
            modifier = Modifier.padding(vertical = 10.dp),
            fontSize = 16.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
        )
    }
}

