package com.example.to_doapp.app_features.presentation.task_overview_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.to_doapp.app_features.domain.use_case.TaskUseCases
import com.example.to_doapp.app_features.presentation.add_edit_task_screen.AddEditTaskEvent
import com.example.to_doapp.app_features.presentation.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class TaskOverviewViewModel @Inject constructor(
    private val taskUseCases: TaskUseCases
) : ViewModel() {

    var state by mutableStateOf(TaskOverviewState())
        private set

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()


    private val localDate = LocalDate.now()

    init {
        getAllTasks()
        viewModelScope.launch {
            getTasksByDate()
        }
    }


    private fun getAllTasks() {
        taskUseCases.getTasks()
            .onEach { tasks ->
                state = state.copy(
                    allTasks = tasks
                )
            }
            .launchIn(viewModelScope)
    }

    private suspend fun getTasksByDate() {
        taskUseCases.getTasksByDate(
            day = localDate.dayOfMonth,
            month = localDate.monthValue,
            year = localDate.year
        )
            ?.onEach { tasks ->
                state = state.copy(
                    dailyTasks = tasks
                )
            }
            ?.launchIn(viewModelScope)
    }

}