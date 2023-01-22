package com.example.to_doapp.app_features.presentation.task_overview_screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.to_doapp.R
import com.example.to_doapp.app_features.presentation.task_overview_screen.components.TaskItem
import com.example.to_doapp.app_features.presentation.task_overview_screen.components.TaskOverviewTopBar
import com.example.to_doapp.app_features.presentation.task_overview_screen.components.TasksContainer
import com.example.to_doapp.app_features.presentation.util.Screen
import com.example.to_doapp.ui.theme.LocalSpacing

@Composable
fun TaskOverviewScreen(
    navController: NavController,
    viewModel: TaskOverviewViewModel = hiltViewModel()
) {

    val spacing = LocalSpacing.current
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.fillMaxSize(),
        topBar = { TaskOverviewTopBar(onAddClick = { navController.navigate(Screen.AddEditTaskScreen.route) }) }
    ) { padding ->
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(padding)
                .background(MaterialTheme.colors.surface)
        ) {
            Spacer(modifier = Modifier.padding(spacing.spaceSmall))
            Text(
                text = "Tasks today",
                modifier = Modifier.padding(spacing.space12),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onPrimary
            )
            TasksContainer(viewModel = viewModel)
            Spacer(modifier = Modifier.padding(spacing.spaceSmall))
            Text(
                text = "All tasks",
                modifier = Modifier.padding(spacing.space12),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onPrimary
            )
            TasksContainer(viewModel = viewModel)


        }

    }

}
