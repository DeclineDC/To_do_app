package com.example.to_doapp.app_features.presentation.add_edit_task_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.to_doapp.app_features.presentation.task_overview_screen.TaskOverviewViewModel

@Composable
fun AddEditTaskScreen(
    navController: NavController,
    viewModel: TaskOverviewViewModel = hiltViewModel()
) {

    val scaffoldState = rememberScaffoldState()

    Scaffold(scaffoldState = scaffoldState, modifier = Modifier.fillMaxSize()) { padding ->
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
