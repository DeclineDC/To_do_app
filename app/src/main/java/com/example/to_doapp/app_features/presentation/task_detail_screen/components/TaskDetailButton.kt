package com.example.to_doapp.app_features.presentation.task_detail_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.to_doapp.ui.theme.LocalSpacing

@Composable
fun TaskDetailButton(
    text: String,
    onClick: () -> Unit,
    color: Color = MaterialTheme.colors.secondary,
    width: Float,
    height: Dp = 48.dp,
    icon: ImageVector,
    modifier: Modifier = Modifier

    ) {

    val spacing = LocalSpacing.current

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        shape = CircleShape,
        elevation = ButtonDefaults.elevation(1.dp),
        modifier = modifier
            .fillMaxWidth(width)
            .padding(spacing.space12)
            .height(height)
    ) {
        Icon(imageVector = icon, contentDescription = null, tint = Color.White)
        Spacer(modifier = Modifier.padding(spacing.spaceExtraSmall))
        Text(
            text = text,
            color = Color.White,
            modifier = Modifier.padding(spacing.spaceExtraSmall),
            style = MaterialTheme.typography.body1
        )
    }
}