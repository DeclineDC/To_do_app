package com.example.to_doapp.app_features.presentation.completed_tasks_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.to_doapp.R
import com.example.to_doapp.app_features.presentation.completed_tasks_screen.CompletedTasksViewModel
import com.example.to_doapp.app_features.presentation.task_overview_screen.TaskOverviewViewModel
import com.example.to_doapp.app_features.presentation.task_overview_screen.components.TaskItem
import com.example.to_doapp.app_features.presentation.task_overview_screen.components.parseDateForTaskItem
import com.example.to_doapp.app_features.presentation.util.Screen
import com.example.to_doapp.ui.theme.LocalSpacing

@Composable
fun CompletedTasksContainer(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: CompletedTasksViewModel
) {

    val spacing = LocalSpacing.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = spacing.space12, end = spacing.space12, bottom = 0.dp, top = 0.dp),
        shape = RoundedCornerShape(spacing.spaceMedium),
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Column(modifier = Modifier.background(MaterialTheme.colors.primary)) {
            LazyColumn(modifier = Modifier.height(290.dp)) {
                if (viewModel.state.allTasks.isNullOrEmpty()) {
                    items(1) {
                        Column(

                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .padding(
                                    top = 55.dp,
                                    bottom = 55.dp
                                )
                        )
                        {
                            Text(
                                text = stringResource(R.string.no_completed_tasks),
                                style = MaterialTheme.typography.h5,
                                color = MaterialTheme.colors.primaryVariant
                            )
                            Spacer(modifier = Modifier.padding(spacing.spaceMedium))

                        }

                    }

                }
                items(viewModel.state.allTasks) { task ->
                    TaskItem(
                        date = parseDateForTaskItem(
                            day = task.day,
                            month = task.month,
                            Year = task.year
                        ),
                        task = task,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .clickable {
                                navController.navigate(Screen.TaskDetailScreen.route + "?taskId=${task.id}")
                            }
                    )
                }
            }
        }

    }

}