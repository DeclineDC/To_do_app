package com.example.to_doapp.app_features.presentation.task_overview_screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.LaunchedEffect
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
import com.example.to_doapp.app_features.presentation.task_overview_screen.components.*
import com.example.to_doapp.app_features.presentation.util.Screen
import com.example.to_doapp.app_features.presentation.util.UiEvent
import com.example.to_doapp.ui.theme.LocalSpacing
import kotlinx.coroutines.flow.collectLatest

@Composable
fun TaskOverviewScreen(
    navController: NavController,
    viewModel: TaskOverviewViewModel = hiltViewModel()
) {

    val spacing = LocalSpacing.current
    val scaffoldState = rememberScaffoldState()

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
        topBar = { TaskOverviewTopBar() }
    ) { padding ->
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(padding)
                .background(MaterialTheme.colors.surface)
        ) {
            Spacer(modifier = Modifier.padding(spacing.spaceExtraSmall))
            Text(
                text = "Tasks Today",
                modifier = Modifier.padding(spacing.spaceMedium),
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onPrimary
            )
            DailyTasksContainer(
                viewModel = viewModel,
                navController = navController
            )
            Spacer(modifier = Modifier.padding(spacing.spaceExtraSmall))
            Text(
                text = "Upcoming Tasks",
                modifier = Modifier.padding(spacing.spaceMedium),
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onPrimary
            )
            AllTasksContainer(
                viewModel = viewModel,
                navController = navController
            )
        }

    }

}