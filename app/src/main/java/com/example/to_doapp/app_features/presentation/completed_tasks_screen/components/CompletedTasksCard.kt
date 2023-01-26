package com.example.to_doapp.app_features.presentation.completed_tasks_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.to_doapp.ui.theme.LocalSpacing

@Composable
fun CompletedTasksCard(
    modifier: Modifier = Modifier
) {

    val spacing = LocalSpacing.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(spacing.space12)
    ) {
        Card(
            shape = RoundedCornerShape(spacing.spaceMedium),
            elevation = 1.dp,
            backgroundColor = MaterialTheme.colors.primary,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = spacing.space12,
                        end = spacing.space12,
                        top = spacing.space12,
                        bottom = spacing.spaceSmall
                    )
            ) {
                Text(text = "You have completed...")
                Spacer(modifier = Modifier.padding(spacing.spaceMedium))
                Text(text = "56", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.padding(spacing.spaceMedium))
                Text(text = "...Tasks so far!", textAlign = TextAlign.End)

            }
        }
    }
}