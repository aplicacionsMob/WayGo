package com.example.waygo.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


@Composable
fun WayGoTheme(content: @Composable () -> Unit) {
    val colors = lightColorScheme(
        primary = PrimaryColor,
        secondary = SecondaryColor,
        background = BackgroundColor,
        surface = Color.White,
        onPrimary = Color.White,
        onSecondary = Color.Black,
        onBackground = TextColor
    )

    MaterialTheme(
        colorScheme = colors,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}
