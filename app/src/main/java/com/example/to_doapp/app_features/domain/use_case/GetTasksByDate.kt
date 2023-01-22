package com.example.to_doapp.app_features.domain.use_case

import com.example.to_doapp.app_features.domain.model.Task
import com.example.to_doapp.app_features.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

class GetTasksByDate(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(day: Int, month: Int, year: Int): Flow<List<Task>>? {
        return repository.getTasksByDate(day, month, year)
    }
}