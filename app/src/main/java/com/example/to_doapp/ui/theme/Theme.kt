package com.example.to_doapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = SurfaceBlack,
    onPrimary = Color.White,
    primaryVariant = Color.LightGray,
    secondary = Cyan,
    surface = Color.Black,
    onSurface = Color.Black,
    onBackground = Color.Black
)

private val LightColorPalette = lightColors(
    primary = Color.White,
    onPrimary = Color.Black,
    primaryVariant = Color.LightGray,
    secondary = Cyan,
    surface = SurfaceWhite,
    onSurface = Color.Black,
    onBackground = Color.Black

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun ToDoAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = if (!darkTheme) Color.White else Color(0xFF181818)
    )
    systemUiController.setSystemBarsColor(
        color = if (!darkTheme) Color.White else Color(0xFF181818)
    )

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}