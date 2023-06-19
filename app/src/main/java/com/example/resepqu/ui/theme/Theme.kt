package com.example.resepqu.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Blue200,
    primaryVariant = Blue700,
    onPrimary = Black,
    secondary = Orange200,
    secondaryVariant = Orange200,
    onSecondary = Black
)

private val LightColorPalette = lightColors(
    primary = Blue500,
    primaryVariant = Blue700,
    onPrimary = White,
    secondary = Orange200,
    secondaryVariant = Orange700,
    onSecondary = Black
)

@Composable
fun ResepQuTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}