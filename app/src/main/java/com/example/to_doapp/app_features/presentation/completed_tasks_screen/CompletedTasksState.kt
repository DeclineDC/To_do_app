package com.example.to_doapp.app_features.presentation.completed_tasks_screen

import com.example.to_doapp.app_features.domain.model.Task
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset

data class CompletedTasksState(
    val allTasks: List<Task> = emptyList(),
    val expiredTasks: List<Task> = emptyList(),
    val currentTime: Long = LocalDate.now().toEpochDay()
)