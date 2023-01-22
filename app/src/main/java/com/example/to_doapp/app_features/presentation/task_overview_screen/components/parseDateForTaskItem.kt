package com.example.to_doapp.app_features.presentation.task_overview_screen.components

import androidx.compose.runtime.Composable
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun parseDateForTaskItem(day: Int, month: Int, Year: Int): String {
    var monthName: String = ""
    when (month) {
         1 -> {monthName = "Jan"}
         2 -> {monthName = "Feb"}
         3 -> {monthName = "Mar"}
         4 -> {monthName = "Apr"}
         5 -> {monthName = "May"}
         6 -> {monthName = "Jun"}
         7 -> {monthName = "Jul"}
         8 -> {monthName = "Aug"}
         9 -> {monthName = "Sep"}
         10 -> {monthName = "Oct"}
         11 -> {monthName = "Nov"}
         12 -> {monthName = "Dec"}
    }
    return "$monthName $day"
}