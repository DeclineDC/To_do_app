package com.example.to_doapp.app_features.presentation.task_detail_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun IconRow(
    icon: ImageVector,
    text: String,
    modifier: Modifier = Modifier
) {

    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.surface)
            .padding(end = 12.dp , bottom = 4.dp)
    ) {
        Text(text = text, style = MaterialTheme.typography.body2)
        Icon(imageVector = icon, contentDescription = null)

    }
}