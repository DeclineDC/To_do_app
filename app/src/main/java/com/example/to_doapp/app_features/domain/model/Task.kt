package com.example.to_doapp.app_features.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    val title: String,
    val description: String,
/*    val dayOfMonth: Int,
    val month: Int,
    val year: Int,
    val importanceOfTask: Int,
    val isExistingTask: Boolean,
    val isTaskRepeatable: Boolean,
    val isTaskNotifying: Boolean,*/
    @PrimaryKey val id: Int? = null
)
