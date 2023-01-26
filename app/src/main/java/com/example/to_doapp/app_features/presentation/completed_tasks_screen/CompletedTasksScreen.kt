package com.example.to_doapp.app_features.presentation.completed_tasks_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.to_doapp.app_features.presentation.completed_tasks_screen.components.CompletedTasksCard
import com.example.to_doapp.app_features.presentation.completed_tasks_screen.components.CompletedTasksContainer
import com.example.to_doapp.app_features.presentation.completed_tasks_screen.components.CompletedTasksTopBar
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

            CompletedTasksCard()
            Spacer(modifier = Modifier.padding(spacing.spaceMedium))
            CompletedTasksContainer(navController, viewModel = viewModel)

        }
    }
}


