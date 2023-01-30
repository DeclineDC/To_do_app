package com.example.to_doapp.app_features.domain.use_case

data class TaskUseCases(
    val addTask: AddTask,
    val deleteTask: DeleteTask,
    val getTask: GetTask,
    val getTasksByDate: GetTasksByDate,
    val getTasks: GetTasks,
    val getCompletedTasks: GetCompletedTasks,
    val getExpiredTasks: GetExpiredTasks
)