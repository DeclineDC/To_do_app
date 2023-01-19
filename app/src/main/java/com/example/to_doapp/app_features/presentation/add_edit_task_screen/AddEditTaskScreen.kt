package com.example.to_doapp.app_features.presentation.add_edit_task_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.to_doapp.app_features.presentation.add_edit_task_screen.components.AddButton
import com.example.to_doapp.app_features.presentation.add_edit_task_screen.components.TextFieldRow
import com.example.to_doapp.app_features.presentation.task_overview_screen.TaskOverviewViewModel
import com.example.to_doapp.app_features.presentation.util.Screen
import com.example.to_doapp.app_features.presentation.util.UiEvent
import kotlinx.coroutines.flow.collectLatest

@Composable
fun AddEditTaskScreen(
    navController: NavController,
    viewModel: AddEditTaskViewModel = hiltViewModel()
) {

    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is UiEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
                is UiEvent.SaveTask -> {
                    navController.navigate(Screen.TaskOverviewScreen.route)
                }
            }
        }
    }

    Scaffold(scaffoldState = scaffoldState, modifier = Modifier.fillMaxSize()) { padding ->
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(padding)
                .background(MaterialTheme.colors.surface)
        ) {

            TextFieldRow(
                text = "Title",
                value = viewModel.state.title,
                color = Color.Black,
                isEditable = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    capitalization = KeyboardCapitalization.Words
                ),
                onValueChange = {
                    viewModel.onEvent(
                        AddEditTaskEvent.OnTitleChange(it)
                    )
                }
            )
            TextFieldRow(
                text = "Description",
                value = viewModel.state.description,
                color = Color.Black,
                isEditable = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                onValueChange = {
                    viewModel.onEvent(
                        AddEditTaskEvent.OnDescriptionChange(it)
                    )
                }
            )

            AddButton(
                text = "Add",
                onClick = { viewModel.onEvent(AddEditTaskEvent.OnSaveTask) },
                color = MaterialTheme.colors.secondary
            )

        }


    }

}
