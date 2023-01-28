package com.example.to_doapp.app_features.presentation.task_overview_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.to_doapp.app_features.domain.model.Task
import com.example.to_doapp.ui.theme.LocalSpacing

@Composable
fun TaskItem(
    date: String,
    task: Task,
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.primary)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(.7f)
                .padding(
                    start = spacing.spaceMedium,
                    end = spacing.spaceMedium,
                    bottom = spacing.space12,
                    top = spacing.space12
                )
                .background(color = MaterialTheme.colors.primary)
        ) {
            Text(
                text = task.title,
                style = MaterialTheme.typography.body1,
                maxLines = 1,
                color = MaterialTheme.colors.onPrimary
            )
            Text(
                text = "${task.description}",
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.primaryVariant,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(top = 4.dp)
                    .offset(x = 2.dp)
            )
        }




        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = spacing.spaceMedium,
                    end = spacing.spaceMedium,
                    bottom = 18.5.dp,
                    top = 18.5.dp
                )
                .background(color = MaterialTheme.colors.primary)
        ) {
            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colors.primary),

                ) {
                Text(
                    text = date,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onPrimary
                )
                Spacer(modifier = Modifier.padding(spacing.spaceExtraSmall))
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = MaterialTheme.colors.secondary
                )
            }


        }

    }
    Divider(modifier = Modifier.padding(start = spacing.spaceMedium, end = spacing.spaceMedium), thickness = .5.dp)


}