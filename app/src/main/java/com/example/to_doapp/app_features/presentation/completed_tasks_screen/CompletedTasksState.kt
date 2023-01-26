package com.example.to_doapp.app_features.presentation.completed_tasks_screen

import com.example.to_doapp.app_features.domain.model.Task

data class CompletedTasksState(
    val allTasks: List<Task> = emptyList()
)