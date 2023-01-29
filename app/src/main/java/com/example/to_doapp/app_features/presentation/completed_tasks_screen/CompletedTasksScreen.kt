package com.example.to_doapp.app_features.presentation.completed_tasks_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.to_doapp.R
import com.example.to_doapp.app_features.presentation.completed_tasks_screen.components.CompletedTasksCard
import com.example.to_doapp.app_features.presentation.completed_tasks_screen.components.CompletedTasksContainer
import com.example.to_doapp.app_features.presentation.completed_tasks_screen.components.CompletedTasksTopBar
import com.example.to_doapp.app_features.presentation.completed_tasks_screen.components.TaskSubContainer
import com.example.to_doapp.app_features.presentation.task_detail_screen.TaskDetailViewModel
import com.example.to_doapp.app_features.presentation.task_detail_screen.components.TaskDetailTopBar
import com.example.to_doapp.app_features.presentation.util.Screen
import com.example.to_doapp.ui.theme.LocalSpacing

@Composable
fun CompletedTasksScreen(
    navController: NavController,
    viewModel: CompletedTasksViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val spacing = LocalSpacing.current



    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CompletedTasksTopBar()
        }
    ) { padding ->
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(padding)
                .background(MaterialTheme.colors.surface)

        ) {
            Spacer(modifier = Modifier.padding(spacing.spaceSmall))

            Row(horizontalArrangement = Arrangement.SpaceAround) {
                TaskSubContainer(
                    completedTasks = viewModel.state.allTasks.size,
                    text = "Completed tasks",
                    textColor = MaterialTheme.colors.secondary,
                    modifier = Modifier.weight(.3f)
                )
                TaskSubContainer(
                    completedTasks = viewModel.state.expiredTasks.size,
                    text = "Expired tasks",
                    textColor = Color(0XFFe07575),
                    modifier = Modifier.weight(.3f)
                )
            }

            Text(
                text = stringResource(R.string.completed_task_C),
                modifier = Modifier.padding(spacing.spaceMedium),
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onPrimary
            )
            CompletedTasksContainer(navController, viewModel = viewModel)

        }
    }
}


