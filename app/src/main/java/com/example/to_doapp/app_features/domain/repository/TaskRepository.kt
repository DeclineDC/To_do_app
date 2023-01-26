package com.example.to_doapp.app_features.domain.repository

import com.example.to_doapp.app_features.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    suspend fun insertTask(task: Task)

    suspend fun deleteTask(task: Task)

    suspend fun getTaskById(id: Int): Task?

    suspend fun getTasksByDate(day: Int, month: Int, year: Int): Flow<List<Task>>?

    fun getCompletedTasks(): Flow<List<Task>>

    fun getTasks(/*day: Int*/): Flow<List<Task>>
}