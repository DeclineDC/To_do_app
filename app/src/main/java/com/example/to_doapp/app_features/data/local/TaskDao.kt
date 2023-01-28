package com.example.to_doapp.app_features.data.local


import androidx.room.*
import com.example.to_doapp.app_features.domain.model.Task
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime
import java.time.ZoneOffset

@Dao
interface TaskDao {

    @Query("SELECT * FROM task WHERE id = :id")
    suspend fun getTaskById(id: Int): Task?

    @Query("SELECT * FROM task WHERE isTaskCompleted = 0 AND dueDate > :currentDateTimeStamp ORDER BY dueDate ASC")
    fun getTasks(
        currentDateTimeStamp: Long = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)
    ): Flow<List<Task>>

    @Query("SELECT * FROM task WHERE day = :day AND month = :month AND year = :year AND isTaskCompleted = 0")
    fun getTasksByDate(day: Int, month: Int, year: Int): Flow<List<Task>>?

    @Query("SELECT * FROM task WHERE isTaskCompleted = 1 ORDER BY dueDate ASC")
    fun getCompletedTasks(): Flow<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)
}