package com.example.to_doapp.app_features.presentation.task_overview_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.to_doapp.app_features.domain.model.Task
import com.example.to_doapp.ui.theme.LocalSpacing

@Composable
fun TaskItem(
    task: Task,
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current

    Column(
        modifier = modifier
            .background(MaterialTheme.colors.surface)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = spacing.spaceMedium,
                    end = spacing.spaceMedium,
                    bottom = spacing.spaceSmall,
                    top = spacing.spaceSmall
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = task.title, style = MaterialTheme.typography.body1)
            Text(
                modifier = Modifier.offset(y = 12.dp),
                text = "${task.description}"
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = spacing.spaceMedium, bottom = spacing.spaceSmall),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "" /*"${task.dayOfMonth}" + "/${task.month}" + "/${task.year}"*/,
                style = MaterialTheme.typography.h5
            )
        }
        Divider(thickness = .5.dp)
    }


}