package com.example.to_doapp.app_features.presentation.add_edit_task_screen

import java.time.LocalDate

data class AddEditTaskState(
    val title: String = "",
    val description: String = "",
    val date: LocalDate = LocalDate.now(),
    val isRepeatableSwitchSelected: Boolean = false,
    val isNotifyingSwitchSelected: Boolean = false
)