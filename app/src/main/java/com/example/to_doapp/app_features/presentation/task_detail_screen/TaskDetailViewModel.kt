package com.example.to_doapp.app_features.presentation.task_detail_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
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
class TaskDetailViewModel @Inject constructor(
    private val taskUseCases: TaskUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var state by mutableStateOf(TaskDetailState())
        private set

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()


    init {
        savedStateHandle.get<Int>("taskId")?.let { taskId ->
            if (taskId != -1) {
                viewModelScope.launch {
                    taskUseCases.getTask(taskId)?.also { task ->
                        state = state.copy(
                            task = task,
                            title = task.title,
                            description = task.description,
                            day = task.day,
                            month = task.month,
                            year = task.year,
                            isTaskRepeatable = task.isTaskRepeatable,
                            isTaskNotifying = task.isTaskNotifying

                        )
                    }
                }
            }
        }
    }

    fun onEvent(event: TaskDetailEvent) {
        when (event) {

            is TaskDetailEvent.OnDeleteTask -> {
                viewModelScope.launch {
                    taskUseCases.deleteTask(event.task)
                    _eventFlow.emit(UiEvent.OnCancelClick)
                }
            }
            TaskDetailEvent.OnCompleteTask -> {
                viewModelScope.launch {
                    try {
                        taskUseCases.addTask(
                            Task(
                                title = state.title,
                                description = state.description,
                                day = state.day,
                                month = state.month,
                                year = state.year,
                                isTaskRepeatable = state.isTaskRepeatable,
                                isTaskNotifying = state.isTaskNotifying,
                                id = state.task?.id,
                                isTaskCompleted = true
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
        }
    }

}