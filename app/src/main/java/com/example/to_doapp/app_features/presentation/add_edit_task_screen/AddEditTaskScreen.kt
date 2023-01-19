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

@Composable
fun AddEditTaskScreen(
    navController: NavController,
    viewModel: AddEditTaskViewModel = hiltViewModel()
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

            TextFieldRow(
                text = "Title",
                value = "test",
                color = Color.Black,
                isEditable = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    capitalization = KeyboardCapitalization.Words
                ),
                onValueChange = {
                }
            )
            TextFieldRow(
                text = "Description",
                value = "test",
                color = Color.Black,
                isEditable = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = {

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
