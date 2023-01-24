package com.example.to_doapp.app_features.presentation.add_edit_task_screen

import java.time.LocalDate

data class AddEditTaskState(
    val title: String = "",
    val description: String = "",
    val date: LocalDate = LocalDate.now(),
    val day: Int = 0,
    val month: Int = 0,
    val year: Int = 0,
    val isRepeatableSwitchSelected: Boolean = false,
    val isNotifyingSwitchSelected: Boolean = false
)