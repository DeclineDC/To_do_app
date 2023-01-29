package com.example.to_doapp.app_features.presentation.add_edit_task_screen.components

import androidx.compose.runtime.Composable
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter


fun parseStringToDate(day: String, month: String, year: String): Long {

    var date: String = when {
        day.length == 1 && month.length == 1 -> {
            "$year-0$month-0$day 00:00"
        }
        day.length == 2 && month.length == 1 -> {
            "$year-0$month-$day 00:00"
        }
        day.length == 1 && month.length == 2 -> {
            "$year-$month-0$day 00:00"
        }
        else -> {
            "$year-$month-$day 00:00"
        }

    }

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
    val localDateTime = LocalDateTime.parse(date, formatter)

    return "${localDateTime.toEpochSecond(ZoneOffset.UTC)}000".toLong()


}