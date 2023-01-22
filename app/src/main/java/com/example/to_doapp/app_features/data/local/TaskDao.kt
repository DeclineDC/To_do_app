package com.example.to_doapp.app_features.data.local


import androidx.room.*
import com.example.to_doapp.app_features.domain.model.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM task WHERE id = :id")
    suspend fun getTaskById(id: Int): Task?

    @Query("SELECT * FROM task")
    fun getTasks(): Flow<List<Task>>

    @Query("SELECT * FROM task WHERE day = :day AND month = :month AND year = :year")
    fun getTasksByDate(day: Int, month: Int, year: Int): Flow<List<Task>>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)
}