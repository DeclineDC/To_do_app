package com.example.to_doapp.app_features.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date

@Entity
data class Task(
    val title: String,
    val description: String,
    val day: Int = 0,
    val month: Int = 0,
    val year: Int = 0,
    val isTaskRepeatable: Boolean,
    val isTaskNotifying: Boolean,
    val isTaskCompleted: Boolean = false,
    @PrimaryKey val id: Int? = null
)
