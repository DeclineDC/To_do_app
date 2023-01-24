package com.example.to_doapp.app_features.presentation.task_detail_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 12.dp, bottom = 4.dp)
    ) {
        Icon(imageVector = icon, contentDescription = null)
        Spacer(modifier = Modifier.padding(2.dp))
        Text(text = text, style = MaterialTheme.typography.body2, modifier = Modifier.offset(y=3.dp))


    }
}