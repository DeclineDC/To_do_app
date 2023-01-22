package com.example.to_doapp.app_features.presentation.add_edit_task_screen.components

import androidx.compose.runtime.Composable
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun parseDate(date: LocalDate): String {
    return DateTimeFormatter.ofPattern("dd/MM/uuuu").format(date)
}