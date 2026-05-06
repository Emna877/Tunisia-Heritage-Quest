package com.example.tunisiaheritagequest.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tunisiaheritagequest.ui.theme.DeepBlue
import com.example.tunisiaheritagequest.ui.theme.GoldAccent
import com.example.tunisiaheritagequest.ui.theme.LightSandBeige
import com.example.tunisiaheritagequest.ui.theme.SandBeige
import com.example.tunisiaheritagequest.ui.theme.SuccessGreen

@Composable
fun HeritagePatternBorder(
    modifier: Modifier = Modifier,
    tint: Color = GoldAccent.copy(alpha = 0.85f)
) {
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(18.dp)
    ) {
        val stroke = Stroke(width = 2.5f)
        val centerY = size.height / 2f
        val step = size.width / 9f

        // Ornamental line with repeated geometric diamonds
        drawLine(tint.copy(alpha = 0.6f), Offset(0f, centerY), Offset(size.width, centerY), 2.5f)
        for (i in 0..9) {
            val x = i * step
            drawLine(tint, Offset(x - 6f, centerY), Offset(x, centerY - 6f), 2.2f)
            drawLine(tint, Offset(x, centerY - 6f), Offset(x + 6f, centerY), 2.2f)
            drawLine(tint, Offset(x + 6f, centerY), Offset(x, centerY + 6f), 2.2f)
            drawLine(tint, Offset(x, centerY + 6f), Offset(x - 6f, centerY), 2.2f)
        }
    }
}

@Composable
fun HeritageDivider(
    modifier: Modifier = Modifier,
    tint: Color = GoldAccent.copy(alpha = 0.5f)
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Canvas(modifier = Modifier.weight(1f).height(8.dp)) {
            val y = size.height / 2f
            drawLine(tint, Offset(0f, y), Offset(size.width, y), 2f)
            drawCircle(tint, radius = 4f, center = Offset(size.width / 2f, y))
        }
        Spacer(modifier = Modifier.padding(horizontal = 10.dp))
        Canvas(modifier = Modifier.weight(1f).height(8.dp)) {
            val y = size.height / 2f
            drawLine(tint, Offset(0f, y), Offset(size.width, y), 2f)
            drawCircle(tint, radius = 4f, center = Offset(size.width / 2f, y))
        }
    }
}

@Composable
fun HeritageCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(26.dp),
        colors = CardDefaults.cardColors(containerColor = LightSandBeige.copy(alpha = 0.92f)),
        border = BorderStroke(1.dp, GoldAccent.copy(alpha = 0.28f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .background(LightSandBeige.copy(alpha = 0.92f))
                .padding(20.dp)
        ) {
            content()
        }
    }
}

@Composable
fun HeritagePrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = DeepBlue,
            contentColor = Color.White
        ),
        border = BorderStroke(1.dp, DeepBlue.copy(alpha = 0.25f))
    ) {
        Text(text = text, fontSize = 17.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
fun HeritageOutlinedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(14.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = DeepBlue
        ),
        border = BorderStroke(1.dp, GoldAccent.copy(alpha = 0.65f))
    ) {
        Text(text = text, fontSize = 14.sp, fontWeight = FontWeight.Medium)
    }
}
