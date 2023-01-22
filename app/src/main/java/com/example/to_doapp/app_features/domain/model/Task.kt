package com.example.to_doapp.app_features.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    val title: String,
    val description: String,
    val day: Int = 0,
    val month: Int = 0,
    val year: Int = 0,
    val isTaskRepeatable: Boolean = false,
    val isTaskNotifying: Boolean = false,
    @PrimaryKey val id: Int? = null
)
