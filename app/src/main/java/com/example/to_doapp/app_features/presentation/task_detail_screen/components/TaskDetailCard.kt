package com.example.to_doapp.app_features.presentation.task_detail_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
            modifier = Modifier.fillMaxHeight(.5f)
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
                Row(Modifier.fillMaxWidth()) {
                    Text(text = "Title")
                }
                Row(Modifier.fillMaxWidth()) {
                    Text(text = "This is where the description of the selected task will go, just writing this for design purposes.")
                }
            }
        }
    }
}