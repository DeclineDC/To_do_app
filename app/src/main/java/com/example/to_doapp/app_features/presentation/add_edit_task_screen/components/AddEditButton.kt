package com.example.to_doapp.app_features.presentation.add_edit_task_screen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import com.example.to_doapp.ui.theme.LocalSpacing

@Composable
fun AddEditButton(
    text: String,
    onClick: () -> Unit,
    color: Color = MaterialTheme.colors.secondary,
    modifier: Modifier = Modifier,

    ) {

    val spacing = LocalSpacing.current

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        shape = CircleShape,
        elevation = ButtonDefaults.elevation(1.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(spacing.space12)
    ) {
        Text(text = text, color = White, modifier = Modifier.padding(spacing.spaceExtraSmall))
    }
}