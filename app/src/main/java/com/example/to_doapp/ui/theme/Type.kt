package com.example.to_doapp.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.to_doapp.R


val Inter = FontFamily(
    Font(R.font.inter_regular),
    Font(R.font.inter_light, FontWeight.Light),
    Font(R.font.inter_bold, FontWeight.Bold),
    Font(R.font.inter_semibold, FontWeight.SemiBold),
    Font(R.font.inter_extrabold, FontWeight.ExtraBold),
    )


// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = Inter,
        fontWeight =  FontWeight.SemiBold,
        fontSize = 14.sp
    ),
    body2 = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp
    ),
    h1 = TextStyle(
        fontFamily = Inter,
        fontWeight =  FontWeight.SemiBold,
        fontSize = 16.sp
    ),
    h2 = TextStyle(
        fontFamily = Inter,
        fontWeight =  FontWeight.Normal,
        fontSize = 18.sp
    ),
    h3 = TextStyle(
        fontFamily = Inter,
        fontWeight =  FontWeight.Bold,
        fontSize = 20.sp
    ),
    h4 = TextStyle(
        fontFamily = Inter,
        fontWeight =  FontWeight.Normal,
        fontSize = 32.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)