package com.example.to_doapp.app_features.presentation.add_edit_task_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.to_doapp.app_features.domain.model.Task
import com.example.to_doapp.app_features.domain.use_case.TaskUseCases
import com.example.to_doapp.app_features.domain.util.InvalidTaskException
import com.example.to_doapp.app_features.presentation.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditTaskViewModel @Inject constructor(
    private val taskUseCases: TaskUseCases
) : ViewModel() {

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    var state by mutableStateOf(AddEditTaskState())
        private set

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
                                isTaskRepeatable = state.isRepeatableSwitchSelected,
                                isTaskNotifying = state.isNotifyingSwitchSelected
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