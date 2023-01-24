package com.example.to_doapp.app_features.presentation.task_detail_screen

import com.example.to_doapp.app_features.domain.model.Task
import java.time.LocalDate

data class TaskDetailState(
    val title: String = "",
    val description: String = "",
    val day: Int = 0,
    val month: Int = 0,
    val year: Int = 0,
    val isTaskRepeatable: Boolean = false,
    val isTaskNotifying: Boolean = false
)