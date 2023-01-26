package com.example.to_doapp.app_features.presentation.completed_tasks_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.to_doapp.R
import com.example.to_doapp.ui.theme.LocalSpacing


@Composable
fun CompletedTasksTopBar(
    modifier: Modifier = Modifier
) {

    val spacing = LocalSpacing.current

    Row(
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.Bottom,
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.1f)
            .background(color = MaterialTheme.colors.primary)
            .padding(start = 12.dp, top = 32.dp, end = 12.dp, bottom = 12.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center, modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Box() {}
            Text(
                text = "Completed Tasks",
                style = MaterialTheme.typography.h2,
                color = MaterialTheme.colors.onPrimary
            )
        }
    }
}
