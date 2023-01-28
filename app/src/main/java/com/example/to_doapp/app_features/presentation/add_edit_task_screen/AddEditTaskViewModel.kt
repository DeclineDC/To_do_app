package com.example.to_doapp.app_features.presentation.add_edit_task_screen

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.to_doapp.app_features.domain.model.Task
import com.example.to_doapp.app_features.domain.use_case.TaskUseCases
import com.example.to_doapp.app_features.domain.util.InvalidTaskException
import com.example.to_doapp.app_features.presentation.add_edit_task_screen.components.parseStringToDate
import com.example.to_doapp.app_features.presentation.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class AddEditTaskViewModel @Inject constructor(
    private val taskUseCases: TaskUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    var state by mutableStateOf(AddEditTaskState())
        private set

    var selectedTask: Task? = null
    var isExistingTask: Boolean = false

    init {
        savedStateHandle.get<Int>("taskId")?.let { taskId ->
            if (taskId != -1) {
                viewModelScope.launch {
                    Log.e("Test", "The value of taskId is $taskId")
                    taskUseCases.getTask(taskId)?.also { task ->
                        isExistingTask = true
                        selectedTask = task
                        state = state.copy(
                            title = task.title,
                            description = task.description,
                            day = task.day,
                            month = task.month,
                            year = task.year,
                            isRepeatableSwitchSelected = task.isTaskRepeatable,
                            isNotifyingSwitchSelected = task.isTaskNotifying
                        )
                    }
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun onEvent(event: AddEditTaskEvent) {
        when (event) {
            is AddEditTaskEvent.OnSaveTask -> {
                viewModelScope.launch {
                    try {
                        taskUseCases.addTask(
                            Task(
                                title = state.title,
                                description = state.description,
                                day = state.date.dayOfMonth,
                                month = state.date.monthValue,
                                year = state.date.year,
                                dueDate = parseStringToDate(
                                    state.date.dayOfMonth.toString(),
                                    state.date.monthValue.toString(),
                                    state.date.year.toString()
                                ),
                                isTaskRepeatable = state.isRepeatableSwitchSelected,
                                isTaskNotifying = state.isNotifyingSwitchSelected,
                                id = selectedTask?.id
                            )
                        )
                        _eventFlow.emit(UiEvent.OnCancelClick)
                    } catch (e: InvalidTaskException) {
                        _eventFlow.emit(
                            UiEvent.ShowSnackBar(
                                message = e.message ?: "Couldn't save task"
                            )
                        )

                    }
                }
            }
            is AddEditTaskEvent.OnDescriptionChange -> {
                state = state.copy(
                    description = event.value
                )
            }
            is AddEditTaskEvent.OnTitleChange -> {
                state = state.copy(
                    title = event.value
                )
            }
            is AddEditTaskEvent.OnCancelClick -> {
                viewModelScope.launch {
                    _eventFlow.emit(UiEvent.OnCancelClick)
                }
            }
            is AddEditTaskEvent.OnDateChange -> {
                isExistingTask = false
                state = state.copy(
                    date = event.localDate
                )
            }
            is AddEditTaskEvent.OnNotifyingSelected -> {
                state = if (!state.isNotifyingSwitchSelected) {
                    state.copy(
                        isNotifyingSwitchSelected = true
                    )
                } else {
                    state.copy(
                        isNotifyingSwitchSelected = false
                    )
                }

            }
            is AddEditTaskEvent.OnRepeatableSelected -> {
                state = if (!state.isRepeatableSwitchSelected) {
                    state.copy(
                        isRepeatableSwitchSelected = true
                    )
                } else {
                    state.copy(
                        isRepeatableSwitchSelected = false
                    )
                }
            }
        }
    }
}