package com.example.to_doapp.app_features.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.to_doapp.app_features.domain.model.Task

@Database(
    entities = [Task::class],
    version = 1
)
abstract class TaskDatabase() : RoomDatabase() {

    abstract val taskDao: TaskDao
}