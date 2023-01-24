package com.example.to_doapp.di

import android.app.Application
import androidx.room.Room
import com.example.to_doapp.app_features.data.local.TaskDatabase
import com.example.to_doapp.app_features.data.repository.TaskRepositoryImpl
import com.example.to_doapp.app_features.data.util.Constants.DATABASE_NAME
import com.example.to_doapp.app_features.domain.repository.TaskRepository
import com.example.to_doapp.app_features.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTaskDatabase(app: Application): TaskDatabase {
        return Room.databaseBuilder(
            app,
            TaskDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideTaskRepository(db: TaskDatabase): TaskRepository {
        return TaskRepositoryImpl(db.taskDao)
    }

    @Provides
    @Singleton
    fun provideTaskUseCases(repository: TaskRepository): TaskUseCases {
        return TaskUseCases(
            addTask = AddTask(repository),
            deleteTask = DeleteTask(repository),
            getTask = GetTask(repository),
            getTasks = GetTasks(repository),
            getTasksByDate = GetTasksByDate(repository),
            getCompletedTasks = GetCompletedTasks(repository)
        )

    }
}