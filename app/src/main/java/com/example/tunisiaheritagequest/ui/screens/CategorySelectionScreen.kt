package com.example.tunisiaheritagequest.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tunisiaheritagequest.ui.components.HeritageDivider
import com.example.tunisiaheritagequest.ui.components.HeritageOutlinedButton
import com.example.tunisiaheritagequest.ui.components.HeritagePatternBorder
import com.example.tunisiaheritagequest.ui.theme.DeepBlue
import com.example.tunisiaheritagequest.ui.theme.GoldAccent
import com.example.tunisiaheritagequest.ui.theme.LightSandBeige
import com.example.tunisiaheritagequest.ui.theme.SandBeige

@Composable
fun CategorySelectionScreen(onCategorySelected: () -> Unit, onBack: () -> Unit) {
    val categories = listOf(
        Triple("Roman Heritage", "10-15 questions", false),
        Triple("Islamic Heritage", "15 questions", true),
        Triple("Punic & Pre-Roman", "5-10 questions", false),
        Triple("Modern Heritage", "5-10 questions", false),
        Triple("Natural & Mixed Sites", "5-10 questions", false),
        Triple("Cities", "5-10 questions", false)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(LightSandBeige, SandBeige.copy(alpha = 0.7f))
                )
            )
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        HeritagePatternBorder()

        Text(
            text = "Heritage Categories",
            style = TextStyle(fontSize = 34.sp, fontWeight = FontWeight.Bold),
            color = DeepBlue,
            modifier = Modifier.padding(top = 14.dp)
        )

        Text(
            text = "Choose a chapter from Tunisia’s heritage",
            style = TextStyle(fontSize = 14.sp),
            color = DeepBlue.copy(alpha = 0.75f)
        )

        HeritageDivider()

        categories.forEach { (category, count, isActive) ->
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.90f)
                    .padding(horizontal = 16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (isActive) Color.White else LightSandBeige.copy(alpha = 0.7f)
                ),
                border = androidx.compose.foundation.BorderStroke(1.dp, GoldAccent.copy(alpha = 0.25f)),
                elevation = CardDefaults.cardElevation(defaultElevation = if (isActive) 4.dp else 0.dp)
            ) {
                Column(
                    modifier = Modifier.padding(14.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = category,
                        style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
                        color = if (isActive) DeepBlue else DeepBlue.copy(alpha = 0.55f)
                    )
                    Text(
                        text = count,
                        style = TextStyle(fontSize = 12.sp),
                        color = GoldAccent
                    )
                    if (!isActive) {
                        Text(
                            text = "Coming Soon",
                            style = TextStyle(fontSize = 11.sp),
                            color = DeepBlue.copy(alpha = 0.45f)
                        )
                    }
                    if (isActive) {
                        HeritageOutlinedButton(
                            text = "Open Islamic Heritage",
                            onClick = onCategorySelected,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }

        HeritageOutlinedButton(
            text = "Main Menu",
            onClick = onBack,
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .padding(vertical = 12.dp)
        )

        HeritagePatternBorder()
    }
}

