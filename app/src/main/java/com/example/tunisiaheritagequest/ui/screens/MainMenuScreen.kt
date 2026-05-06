package com.example.tunisiaheritagequest.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.tunisiaheritagequest.ui.components.HeritageCard
import com.example.tunisiaheritagequest.ui.components.HeritageDivider
import com.example.tunisiaheritagequest.ui.components.HeritageOutlinedButton
import com.example.tunisiaheritagequest.ui.components.HeritagePatternBorder
import com.example.tunisiaheritagequest.ui.components.HeritagePrimaryButton
import com.example.tunisiaheritagequest.ui.theme.DeepBlue
import com.example.tunisiaheritagequest.ui.theme.GoldAccent
import com.example.tunisiaheritagequest.ui.theme.LightSandBeige
import com.example.tunisiaheritagequest.ui.theme.SandBeige

@Composable
fun MainMenuScreen(onStartClick: () -> Unit) {
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
                .fillMaxWidth(0.9f)
                .padding(horizontal = 18.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = TextStyle(
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    color = DeepBlue
                )

                HeritageDivider()

                Text(
                    text = stringResource(R.string.menu_tagline),
                    style = TextStyle(fontSize = 15.sp),
                    color = DeepBlue.copy(alpha = 0.78f),
                    modifier = Modifier.padding(horizontal = 8.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                HeritagePrimaryButton(
                    text = stringResource(R.string.menu_start),
                    onClick = onStartClick,
                    modifier = Modifier.fillMaxWidth()
                )

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    HeritageOutlinedButton(
                        text = stringResource(R.string.menu_how_to_play),
                        onClick = { },
                        modifier = Modifier.fillMaxWidth(0.78f)
                    )
                    HeritageOutlinedButton(
                        text = stringResource(R.string.menu_settings),
                        onClick = { },
                        modifier = Modifier.fillMaxWidth(0.78f)
                    )
                    HeritageOutlinedButton(
                        text = stringResource(R.string.menu_leaderboard),
                        onClick = { },
                        modifier = Modifier.fillMaxWidth(0.78f)
                    )
                }
            }
        }

        HeritagePatternBorder()
    }
}

