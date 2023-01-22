package com.example.to_doapp.app_features.presentation.task_detail_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.to_doapp.app_features.presentation.add_edit_task_screen.AddEditTaskEvent
import com.example.to_doapp.app_features.presentation.add_edit_task_screen.AddEditTaskViewModel
import com.example.to_doapp.app_features.presentation.add_edit_task_screen.components.AddEditTaskTopBar
import com.example.to_doapp.app_features.presentation.task_detail_screen.components.TaskDetailTopBar
import com.example.to_doapp.app_features.presentation.util.Screen
import com.example.to_doapp.ui.theme.LocalSpacing

@Composable
fun TaskDetailScreen(
    navController: NavController,
    viewModel: TaskDetailViewModel = hiltViewModel()
) {

    val scaffoldState = rememberScaffoldState()
    val spacing = LocalSpacing.current

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

        }
    }
}