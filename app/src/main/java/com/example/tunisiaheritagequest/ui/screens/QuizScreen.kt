package com.example.tunisiaheritagequest.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import com.example.tunisiaheritagequest.R
import com.example.tunisiaheritagequest.ui.theme.DeepBlue
import com.example.tunisiaheritagequest.ui.theme.ErrorRed
import com.example.tunisiaheritagequest.ui.theme.GoldAccent
import com.example.tunisiaheritagequest.ui.theme.LightSandBeige
import com.example.tunisiaheritagequest.ui.theme.SandBeige
import com.example.tunisiaheritagequest.ui.theme.SuccessGreen
import com.example.tunisiaheritagequest.viewmodel.QuizViewModel
import kotlinx.coroutines.delay

@Composable
fun QuizScreen(
    viewModel: QuizViewModel,
    onQuizCompleted: () -> Unit
) {
    val questions by viewModel.questions.collectAsState()
    val currentIndex by viewModel.currentQuestionIndex.collectAsState()
    val selectedAnswer by viewModel.selectedAnswerIndex.collectAsState()
    val showFeedback by viewModel.showFeedback.collectAsState()
    val quizEnded by viewModel.quizEnded.collectAsState()
    val timerEnabled by viewModel.timerEnabled.collectAsState()
    val timeRemaining by viewModel.timeRemaining.collectAsState()

    LaunchedEffect(quizEnded) {
        if (quizEnded) {
            delay(500)
            onQuizCompleted()
        }
    }

    LaunchedEffect(currentIndex, showFeedback) {
        if (timerEnabled && !showFeedback) {
            viewModel.updateTimeRemaining(15)
        }
    }

    LaunchedEffect(showFeedback, timerEnabled, timeRemaining) {
        if (timerEnabled && !showFeedback && timeRemaining > 0) {
            delay(1000)
            viewModel.updateTimeRemaining(timeRemaining - 1)
        }
    }

    if (questions.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize().background(LightSandBeige), contentAlignment = Alignment.Center) {
            Text("Loading questions...")
        }
        return
    }

    val currentQuestion = questions.getOrNull(currentIndex) ?: return

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightSandBeige)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Progress Bar
        LinearProgressIndicator(
            progress = { (currentIndex + 1) / questions.size.toFloat() },
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp),
            color = GoldAccent,
            trackColor = SandBeige
        )

        // Header with Question Counter and Timer
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(DeepBlue)
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Q${currentIndex + 1} of ${questions.size}",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )

            if (timerEnabled) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(
                            when {
                                timeRemaining <= 5 -> ErrorRed
                                else -> GoldAccent
                            }
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "$timeRemaining",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Monument Image - Large and Prominent
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = currentQuestion.imageResId),
                    contentDescription = currentQuestion.text,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            // Question Text - Simplified
            Text(
                text = "What is this monument?",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = DeepBlue,
                textAlign = TextAlign.Center
            )

            // Location Badge
            Card(
                modifier = Modifier.fillMaxWidth(0.8f),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = GoldAccent.copy(alpha = 0.2f))
            ) {
                Text(
                    text = "📍 ${currentQuestion.location}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    fontSize = 13.sp,
                    color = DeepBlue,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
            }

            // Answer Grid
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                currentQuestion.options.forEachIndexed { index, option ->
                    AnswerButtonRefactored(
                        text = option,
                        isSelected = selectedAnswer == index,
                        isCorrect = index == currentQuestion.correctAnswerIndex,
                        showFeedback = showFeedback,
                        onClick = { if (!showFeedback) viewModel.selectAnswer(index) }
                    )
                }
            }

            // Feedback Section
            AnimatedVisibility(
                visible = showFeedback,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = if (selectedAnswer == currentQuestion.correctAnswerIndex) {
                                SuccessGreen.copy(alpha = 0.15f)
                            } else {
                                ErrorRed.copy(alpha = 0.15f)
                            }
                        ),
                        border = BorderStroke(
                            1.5.dp,
                            if (selectedAnswer == currentQuestion.correctAnswerIndex) SuccessGreen else ErrorRed
                        )
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = if (selectedAnswer == currentQuestion.correctAnswerIndex) {
                                    "✓ Correct!"
                                } else {
                                    "✗ Incorrect"
                                },
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (selectedAnswer == currentQuestion.correctAnswerIndex) {
                                    SuccessGreen
                                } else {
                                    ErrorRed
                                },
                                modifier = Modifier.padding(bottom = 8.dp)
                            )

                            if (selectedAnswer != currentQuestion.correctAnswerIndex) {
                                Text(
                                    text = "Answer: ${currentQuestion.options[currentQuestion.correctAnswerIndex]}",
                                    fontSize = 14.sp,
                                    color = DeepBlue,
                                    fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier.padding(bottom = 8.dp)
                                )

                                Text(
                                    text = currentQuestion.keyFact,
                                    fontSize = 13.sp,
                                    color = DeepBlue.copy(alpha = 0.8f),
                                    lineHeight = 18.sp
                                )
                            }
                        }
                    }
                }
            }

            // Action Buttons
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(
                    onClick = { if (showFeedback) viewModel.skipQuestion() },
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp),
                    enabled = showFeedback,
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = SandBeige,
                        contentColor = DeepBlue,
                        disabledContainerColor = SandBeige.copy(alpha = 0.5f),
                        disabledContentColor = DeepBlue.copy(alpha = 0.5f)
                    )
                ) {
                    Text("Skip", fontWeight = FontWeight.SemiBold)
                }

                Button(
                    onClick = { if (showFeedback) viewModel.nextQuestion() },
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp),
                    enabled = showFeedback,
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = GoldAccent,
                        contentColor = DeepBlue,
                        disabledContainerColor = GoldAccent.copy(alpha = 0.5f),
                        disabledContentColor = DeepBlue.copy(alpha = 0.5f)
                    )
                ) {
                    Text("Next", fontWeight = FontWeight.SemiBold)
                }
            }

            Box(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun AnswerButtonRefactored(
    text: String,
    isSelected: Boolean,
    isCorrect: Boolean,
    showFeedback: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = when {
        !showFeedback -> if (isSelected) DeepBlue.copy(alpha = 0.1f) else Color.White
        isSelected && isCorrect -> SuccessGreen.copy(alpha = 0.15f)
        isSelected && !isCorrect -> ErrorRed.copy(alpha = 0.15f)
        !isSelected && isCorrect && showFeedback -> SuccessGreen.copy(alpha = 0.1f)
        else -> Color.White
    }

    val borderColor = when {
        !showFeedback && isSelected -> DeepBlue
        showFeedback && isSelected && isCorrect -> SuccessGreen
        showFeedback && isSelected && !isCorrect -> ErrorRed
        showFeedback && !isSelected && isCorrect -> SuccessGreen
        else -> SandBeige
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        border = BorderStroke(1.5.dp, borderColor)
    ) {
        Button(
            onClick = onClick,
            enabled = !showFeedback,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = DeepBlue,
                disabledContainerColor = Color.Transparent,
                disabledContentColor = DeepBlue
            )
        ) {
            Text(
                text = text,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

