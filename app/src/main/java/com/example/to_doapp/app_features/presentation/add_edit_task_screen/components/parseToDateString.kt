package com.example.to_doapp.app_features.presentation.add_edit_task_screen.components

import androidx.compose.runtime.Composable

@Composable
fun parseToDateString(day: String, month: String, year: String): String {
    if (day.length == 1 && month.length == 1) {
        return "0$day/0$month/$year"
    }
    if (day.length == 2 && month.length == 1) {
        return "$day/0$month/$year"
    }
    if (day.length == 1 && month.length == 2) {
        return "0$day/$month/$year"
    } else {
        return "$day/$month/$year"
    }

}