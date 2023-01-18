package com.example.to_doapp.app_features.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [],
    version = 1
)
abstract class TaskDatabase() : RoomDatabase() {

    abstract val taskDao: TaskDao
}