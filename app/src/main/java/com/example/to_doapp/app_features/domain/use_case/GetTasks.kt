package com.example.to_doapp.app_features.domain.use_case

import com.example.to_doapp.app_features.domain.model.Task
import com.example.to_doapp.app_features.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

class GetTasks(
    private val repository: TaskRepository
) {
    operator fun invoke(/*day: Int*/): Flow<List<Task>> {
        return repository.getTasks(/*day*/)
    }
}