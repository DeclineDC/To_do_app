package com.example.to_doapp.app_features.domain.use_case

import com.example.to_doapp.app_features.domain.model.Task
import com.example.to_doapp.app_features.domain.repository.TaskRepository

class DeleteTask(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(task: Task) {
        repository.deleteTask(task)
    }
}