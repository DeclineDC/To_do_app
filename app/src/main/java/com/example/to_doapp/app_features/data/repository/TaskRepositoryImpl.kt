package com.example.to_doapp.app_features.data.repository

import com.example.to_doapp.app_features.data.local.TaskDao
import com.example.to_doapp.app_features.domain.model.Task
import com.example.to_doapp.app_features.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

class TaskRepositoryImpl(private val dao: TaskDao) : TaskRepository {
    override suspend fun insertTask(task: Task) {
        return dao.insertTask(task)
    }

    override suspend fun deleteTask(task: Task) {
        return dao.deleteTask(task)
    }

    override suspend fun getTaskById(id: Int): Task? {
        return dao.getTaskById(id)
    }

    override suspend fun getTasksByDate(day: Int, month: Int, year: Int): Flow<List<Task>>? {
        return dao.getTasksByDate(day, month, year)
    }

    override fun getTasks(): Flow<List<Task>> {
        return dao.getTasks()
    }
}