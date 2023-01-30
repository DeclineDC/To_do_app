package com.example.to_doapp.app_features.presentation.completed_tasks_screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.to_doapp.app_features.domain.use_case.TaskUseCases
import com.example.to_doapp.app_features.presentation.task_detail_screen.TaskDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.time.LocalDateTime
import java.time.ZoneOffset
import javax.inject.Inject

@HiltViewModel
class CompletedTasksViewModel @Inject constructor(
    private val taskUseCases: TaskUseCases
) : ViewModel() {

    var state by mutableStateOf(CompletedTasksState())
        private set

    init {
        getTasks()
    }


    private fun getTasks() {
        Log.e("Time", "${state.currentTime}")
        taskUseCases.getCompletedTasks()
            .onEach { tasks ->
                state = state.copy(
                    allTasks = tasks
                )
            }
            .launchIn(viewModelScope)
        taskUseCases.getExpiredTasks()
            .onEach { tasks ->
                state = state.copy(
                    expiredTasks = tasks
                )
            }
            .launchIn(viewModelScope)
    }

}