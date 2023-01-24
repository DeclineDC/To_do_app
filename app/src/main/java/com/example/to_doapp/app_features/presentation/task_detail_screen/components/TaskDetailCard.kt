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
import androidx.compose.ui.unit.dp
import com.example.to_doapp.ui.theme.LocalSpacing


@Composable
fun TaskDetailCard() {


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
                    Text(text = "Title", style = MaterialTheme.typography.h4)
                }
                Spacer(modifier = Modifier.padding(spacing.spaceSmall))
                Row(Modifier.fillMaxWidth()) {
                    Text(
                        text = "This is where the description of the selected task will go, just writing this for design purposes.",
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
                        IconRow(icon = Icons.Default.Refresh, text = "Repeating")
                        IconRow(icon = Icons.Default.Notifications, text = "Notifying")
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
                            text = "22/01/2023",
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }

            }
        }
    }
}