package com.example.tunisiaheritagequest.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tunisiaheritagequest.R
import com.example.tunisiaheritagequest.ui.components.HeritageCard
import com.example.tunisiaheritagequest.ui.components.HeritageDivider
import com.example.tunisiaheritagequest.ui.components.HeritageOutlinedButton
import com.example.tunisiaheritagequest.ui.components.HeritagePatternBorder
import com.example.tunisiaheritagequest.ui.theme.DeepBlue
import com.example.tunisiaheritagequest.ui.theme.GoldAccent
import com.example.tunisiaheritagequest.ui.theme.LightSandBeige
import com.example.tunisiaheritagequest.ui.theme.SandBeige
import com.example.tunisiaheritagequest.ui.theme.SuccessGreen

@Composable
fun ResultsScreen(
    score: Int,
    totalQuestions: Int,
    onPlayAgain: () -> Unit,
    onMainMenu: () -> Unit
) {
    val percentage = (score * 100) / totalQuestions
    val performanceMessage = when {
        percentage >= 80 -> stringResource(R.string.excellent)
        percentage >= 60 -> stringResource(R.string.good)
        percentage >= 40 -> stringResource(R.string.average)
        else -> stringResource(R.string.needs_improvement)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(LightSandBeige, SandBeige.copy(alpha = 0.8f))
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
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Text(
                    text = stringResource(R.string.quiz_completed),
                    style = TextStyle(fontSize = 34.sp, fontWeight = FontWeight.Bold),
                    color = DeepBlue
                )

                HeritageDivider()

                Text(
                    text = stringResource(R.string.your_score),
                    style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold),
                    color = DeepBlue
                )

                Card(
                    modifier = Modifier.fillMaxWidth(0.82f),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = androidx.compose.foundation.BorderStroke(1.dp, GoldAccent.copy(alpha = 0.22f))
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(R.string.percentage, percentage),
                            style = TextStyle(fontSize = 72.sp, fontWeight = FontWeight.Bold),
                            color = GoldAccent
                        )
                        Text(
                            text = stringResource(R.string.correct_answers, score, totalQuestions),
                            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.SemiBold),
                            color = DeepBlue.copy(alpha = 0.8f),
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = SuccessGreen.copy(alpha = 0.10f)),
                    border = androidx.compose.foundation.BorderStroke(1.dp, SuccessGreen.copy(alpha = 0.5f))
                ) {
                    Text(
                        text = performanceMessage,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = DeepBlue,
                        textAlign = TextAlign.Center
                    )
                }

                HeritageOutlinedButton(
                    text = stringResource(R.string.play_again),
                    onClick = onPlayAgain,
                    modifier = Modifier.fillMaxWidth(0.86f)
                )

                HeritageOutlinedButton(
                    text = stringResource(R.string.main_menu),
                    onClick = onMainMenu,
                    modifier = Modifier.fillMaxWidth(0.86f)
                )
            }
        }

        HeritagePatternBorder()
    }
}

