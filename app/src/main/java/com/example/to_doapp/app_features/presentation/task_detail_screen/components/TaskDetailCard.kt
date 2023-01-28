package com.example.to_doapp.app_features.presentation.task_detail_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.to_doapp.ui.theme.LocalSpacing


@Composable
fun TaskDetailCard(
    title: String,
    description: String,
    date: String,
    isTaskRepeating: Boolean,
    isTaskNotifying: Boolean
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
            modifier = Modifier.fillMaxHeight(.6f)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = spacing.spaceMedium,
                        end = spacing.spaceMedium,
                        top = spacing.space12,
                        bottom = spacing.spaceMedium
                    )
            ) {
                Row(Modifier.fillMaxWidth()) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.h4,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Spacer(modifier = Modifier.padding(spacing.spaceSmall))
                Row(Modifier.fillMaxWidth()) {
                    Text(
                        text = description,
                        maxLines = 6,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.offset(x = 5.dp)
                    )
                }
                Row(Modifier.fillMaxWidth()) {
                    Column(
                        verticalArrangement = Arrangement.Bottom,
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(.5f)
                    ) {
                        IconRow(
                            icon = Icons.Default.Refresh,
                            text = "Repeating",
                            isEnabled = isTaskRepeating
                        )
                        IconRow(
                            icon = Icons.Default.Notifications,
                            text = "Notifying",
                            isEnabled = isTaskNotifying
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.End,
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Due by",
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.Normal
                        )
                        Text(
                            text = date,
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }

            }
        }
    }
}