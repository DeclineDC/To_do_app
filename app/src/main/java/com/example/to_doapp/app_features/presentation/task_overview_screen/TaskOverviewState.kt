package com.example.to_doapp.app_features.presentation.task_overview_screen

import com.example.to_doapp.app_features.domain.model.Task

data class TaskOverviewState(
    val allTasks: List<Task> = emptyList(),
    val dailyTasks: List<Task> = emptyList(),

)