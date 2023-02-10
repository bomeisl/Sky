package com.example.sky.ui.navigation

import androidx.compose.foundation.layout.Row
import androidx.compose.material.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

@Composable
fun FloatActionButton(
    onClick: () -> Unit,
    background: Color,
    icon: Painter,
    text: String
) {
    Row() {
        FloatingActionButton(
            onClick = {
                onClick
            },
            backgroundColor = background,
            content = { icon }
        )
    }
}