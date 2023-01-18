package com.example.to_doapp.app_features.domain.use_case

import com.example.to_doapp.app_features.domain.model.Task
import com.example.to_doapp.app_features.domain.repository.TaskRepository
import com.example.to_doapp.app_features.domain.util.InvalidTaskException

class AddTask(
    private val repository: TaskRepository
) {
    @Throws(InvalidTaskException::class)
    suspend operator fun invoke(task: Task) {
        if (task.title.isBlank()) {
            throw InvalidTaskException("Enter a Title")
        }
        repository.insertTask(task)
    }
}