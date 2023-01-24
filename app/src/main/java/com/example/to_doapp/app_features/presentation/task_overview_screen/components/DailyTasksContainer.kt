package com.example.to_doapp.app_features.presentation.task_overview_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.to_doapp.app_features.presentation.task_overview_screen.TaskOverviewViewModel
import com.example.to_doapp.app_features.presentation.util.Screen
import com.example.to_doapp.ui.theme.LocalSpacing

@Composable
fun DailyTasksContainer(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: TaskOverviewViewModel
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
            LazyColumn(modifier = Modifier.height(190.dp)) {
                items(viewModel.state.dailyTasks) { task ->
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