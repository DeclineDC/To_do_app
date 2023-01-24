package com.example.to_doapp.app_features.presentation.task_detail_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.to_doapp.app_features.presentation.task_detail_screen.components.TaskDetailButton
import com.example.to_doapp.app_features.presentation.task_detail_screen.components.TaskDetailCard
import com.example.to_doapp.app_features.presentation.task_detail_screen.components.TaskDetailTopBar
import com.example.to_doapp.app_features.presentation.util.Screen
import com.example.to_doapp.app_features.presentation.util.UiEvent
import com.example.to_doapp.ui.theme.LocalSpacing
import kotlinx.coroutines.flow.collectLatest

@Composable
fun TaskDetailScreen(
    navController: NavController,
    viewModel: TaskDetailViewModel = hiltViewModel()
) {

    val scaffoldState = rememberScaffoldState()
    val spacing = LocalSpacing.current

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is UiEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
                UiEvent.OnCancelClick -> {
                    navController.navigate(Screen.TaskOverviewScreen.route)
                }
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TaskDetailTopBar(onCancelClick = { navController.navigate(Screen.TaskOverviewScreen.route) })
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

            TaskDetailCard(
                title = viewModel.state.title,
                description = viewModel.state.description,
                date = "24/01/2023",
                isTaskNotifying = viewModel.state.isTaskNotifying,
                isTaskRepeating = viewModel.state.isTaskRepeatable
            )

            Spacer(modifier = Modifier.padding(spacing.spaceLarge))

            Row(Modifier.fillMaxWidth()) {
                TaskDetailButton(
                    text = "Edit Task",
                    onClick = { navController.navigate(Screen.AddEditTaskScreen.route + "?taskId=${viewModel.state.task?.id}") },
                    width = .5f,
                    color = MaterialTheme.colors.primaryVariant,
                    icon = Icons.Default.Edit
                )
                TaskDetailButton(
                    text = "Delete Task",
                    onClick = { viewModel.onEvent(TaskDetailEvent.OnDeleteTask(viewModel.state.task!!)) },
                    width = 1f,
                    color = Color(0XFFe07575),
                    icon = Icons.Default.Delete
                )
            }

            TaskDetailButton(
                text = "Complete Task",
                onClick = { viewModel.onEvent(TaskDetailEvent.OnCompleteTask) },
                width = 1f,
                icon = Icons.Default.Check
            )


        }
    }
}