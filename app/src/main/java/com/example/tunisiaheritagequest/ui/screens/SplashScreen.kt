package com.example.tunisiaheritagequest.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.tunisiaheritagequest.R
import com.example.tunisiaheritagequest.ui.components.HeritagePatternBorder
import com.example.tunisiaheritagequest.ui.theme.DeepBlue
import com.example.tunisiaheritagequest.ui.theme.GoldAccent
import com.example.tunisiaheritagequest.ui.theme.SandBeige
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onSplashComplete: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(3000)
        onSplashComplete()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.radialGradient(
                    colors = listOf(DeepBlue, DeepBlue.copy(alpha = 0.93f), SandBeige.copy(alpha = 0.18f))
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        HeritagePatternBorder(tint = GoldAccent.copy(alpha = 0.8f))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.splash_title),
                style = TextStyle(
                    fontSize = 46.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = androidx.compose.ui.text.font.FontFamily.Serif
                ),
                color = GoldAccent
            )

            Text(
                text = stringResource(R.string.splash_subtitle),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = androidx.compose.ui.text.font.FontFamily.Serif
                ),
                color = Color.White.copy(alpha = 0.92f)
            )
        }

        HeritagePatternBorder(tint = GoldAccent.copy(alpha = 0.8f))
    }
}

