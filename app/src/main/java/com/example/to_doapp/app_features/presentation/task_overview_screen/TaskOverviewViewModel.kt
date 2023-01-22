package com.example.to_doapp.app_features.presentation.task_overview_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.to_doapp.app_features.domain.use_case.TaskUseCases
import com.example.to_doapp.app_features.presentation.add_edit_task_screen.AddEditTaskEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TaskOverviewViewModel @Inject constructor(
    private val taskUseCases: TaskUseCases
) : ViewModel() {

    var state by mutableStateOf(TaskOverviewState())
        private set

    init {
        getAllTasks()
    }


    fun onEvent(event: TaskOverviewEvent) {
        when (event) {

            is TaskOverviewEvent.OnAddTask -> {

            }
            is TaskOverviewEvent.OnTaskSelect -> {

            }
        }
    }

    private fun getAllTasks() {
        taskUseCases.getTasks()
            .onEach { tasks ->
                state = state.copy(
                    tasks = tasks
                )
            }
            .launchIn(viewModelScope)
    }
}