package com.example.to_doapp.app_features.presentation.util

sealed class Screen(val route: String) {
    object TaskOverviewScreen : Screen("task_overview_screen")
    object AddEditTaskScreen : Screen("add_edit_task_screen")
}
