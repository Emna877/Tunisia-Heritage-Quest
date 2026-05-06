package com.example.tunisiaheritagequest.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = DeepBlue,
    secondary = GoldAccent,
    tertiary = SandBeige,
    background = DarkDeepBlue,
    surface = Color(0xFF1A2840),
    onPrimary = Color.White,
    onSecondary = DarkDeepBlue,
    onTertiary = DarkDeepBlue,
    onBackground = SandBeige,
    onSurface = SandBeige,
    error = ErrorRed,
    errorContainer = Color(0xFF5E2C2A)
)

private val LightColorScheme = lightColorScheme(
    primary = DeepBlue,
    secondary = GoldAccent,
    tertiary = SandBeige,
    background = LightSandBeige,
    surface = White,
    onPrimary = White,
    onSecondary = DeepBlue,
    onTertiary = DeepBlue,
    onBackground = DeepBlue,
    onSurface = DeepBlue,
    error = ErrorRed,
    errorContainer = Color(0xFFFCE4EC)
)

@Composable
fun TunisiaHeritageQuestTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}