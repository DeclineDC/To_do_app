package com.example.to_doapp.app_features.presentation.task_detail_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.to_doapp.app_features.presentation.add_edit_task_screen.AddEditTaskEvent
import com.example.to_doapp.app_features.presentation.add_edit_task_screen.AddEditTaskViewModel
import com.example.to_doapp.app_features.presentation.add_edit_task_screen.components.AddEditTaskTopBar
import com.example.to_doapp.app_features.presentation.task_detail_screen.components.TaskDetailButton
import com.example.to_doapp.app_features.presentation.task_detail_screen.components.TaskDetailCard
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

            Spacer(modifier = Modifier.padding(spacing.spaceSmall))

            TaskDetailCard()

            Spacer(modifier = Modifier.padding(spacing.spaceExtraLarge))

            Row(Modifier.fillMaxWidth()) {
                TaskDetailButton(
                    text = "Edit Task",
                    onClick = { /*TODO*/ },
                    width = .5f,
                    color = MaterialTheme.colors.primaryVariant/*Color(0XFF33AFD3)*/,
                    icon = Icons.Default.Edit
                )
                TaskDetailButton(
                    text = "Delete Task",
                    onClick = { /*TODO*/ },
                    width = 1f,
                    color = Color(0XFFe07575),
                    icon = Icons.Default.Delete
                )
            }

            TaskDetailButton(text = "Complete Task", onClick = { /*TODO*/ }, width = 1f, icon = Icons.Default.Check)


        }
    }
}