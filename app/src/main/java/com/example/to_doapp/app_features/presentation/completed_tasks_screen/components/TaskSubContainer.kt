package com.example.to_doapp.app_features.presentation.completed_tasks_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.to_doapp.R
import com.example.to_doapp.ui.theme.LocalSpacing

@Composable
fun TaskSubContainer(
    text: String,
    textColor: Color,
    completedTasks: Int,
    modifier: Modifier = Modifier
) {

    val spacing = LocalSpacing.current

    Row(
        modifier = modifier
            .padding(spacing.space12)
    ) {
        Card(
            shape = RoundedCornerShape(spacing.spaceMedium),
            elevation = 1.dp,
            backgroundColor = MaterialTheme.colors.primary,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        spacing.spaceMedium
                    )
            ) {
                Text(
                    text = "$completedTasks",
                    color = textColor,
                    style = MaterialTheme.typography.h6
                )
                Spacer(modifier = Modifier.padding(spacing.spaceSmall))
                Text(text = "$text", style = MaterialTheme.typography.h1, color = Color.Gray)

            }
        }
    }
}