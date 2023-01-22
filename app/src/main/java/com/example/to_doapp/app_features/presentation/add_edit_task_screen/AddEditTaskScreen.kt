package com.example.to_doapp.app_features.presentation.add_edit_task_screen

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.to_doapp.R
import com.example.to_doapp.app_features.presentation.add_edit_task_screen.components.*
import com.example.to_doapp.app_features.presentation.util.Screen
import com.example.to_doapp.app_features.presentation.util.UiEvent
import com.example.to_doapp.ui.theme.LocalSpacing
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.DatePickerDefaults
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.collectLatest
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AddEditTaskScreen(
    navController: NavController,
    viewModel: AddEditTaskViewModel = hiltViewModel()
) {

    val scaffoldState = rememberScaffoldState()
    val spacing = LocalSpacing.current
    val isRepeatableSelected = viewModel.state.isRepeatableSwitchSelected
    val isNotifyingSelected = viewModel.state.isNotifyingSwitchSelected

    var selectedDate by remember {
        mutableStateOf(LocalDate.now())
    }
    var selectedTime by remember {
        mutableStateOf(LocalTime.NOON)
    }
    val formattedDate by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("MMM dd yyyy")
                .format(selectedDate)
        }
    }

    val dateDialogState = rememberMaterialDialogState()

    val datePickerDialog =
        MaterialDialog(
            dialogState = dateDialogState,
            buttons = {
                positiveButton(
                    text = "Ok",
                    textStyle = TextStyle(color = MaterialTheme.colors.onPrimary)
                )
                negativeButton(
                    text = "Cancel",
                    textStyle = TextStyle(color = MaterialTheme.colors.onPrimary)
                )
            }
        ) {
            datepicker(
                initialDate = LocalDate.now(),
                title = "Select a date",
                colors = DatePickerDefaults.colors(dateActiveBackgroundColor = MaterialTheme.colors.secondary)

            ) {
                selectedDate = it
            }
        }

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
            AddEditTaskTopBar(
                onAddClick = {},
                onDeleteClick = {},
                onCancelClick = { viewModel.onEvent(AddEditTaskEvent.OnCancelClick) })
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

            CardForm(
                text = stringResource(R.string.title),
                value = viewModel.state.title,
                isEditable = true,
                onValueChange = { viewModel.onEvent(AddEditTaskEvent.OnTitleChange(it)) },
                keyboardOptions = KeyboardOptions(KeyboardCapitalization.Words)
            )

            CardForm(
                text = stringResource(R.string.description),
                value = viewModel.state.description,
                isEditable = true,
                onValueChange = { viewModel.onEvent(AddEditTaskEvent.OnDescriptionChange(it)) },
                keyboardOptions = KeyboardOptions(KeyboardCapitalization.Sentences)
            )

            DateCardForm(
                value = "21/01/2023",
                isEditable = false,
                onValueChange = {},
                keyboardOptions = KeyboardOptions(),
                onDateSelect = { dateDialogState.show() }
            )
            SwitchCardForm(
                isNotifyingChecked = isNotifyingSelected,
                onNotifyingCheckedChange = { viewModel.onEvent(AddEditTaskEvent.OnNotifyingSelected) },
                isRepeatableChecked = isRepeatableSelected,
                onRepeatableCheckedChange = { viewModel.onEvent(AddEditTaskEvent.OnRepeatableSelected) }
            )
            AddEditButton(
                text = stringResource(R.string.save_task),
                onClick = { viewModel.onEvent(AddEditTaskEvent.OnSaveTask) })

        }


    }
}

