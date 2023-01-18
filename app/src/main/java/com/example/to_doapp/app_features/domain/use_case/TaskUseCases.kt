package com.example.to_doapp.app_features.domain.use_case

data class TaskUseCases(
    val addTask: AddTask,
    val deleteTask: DeleteTask,
    val getTask: GetTask,
    val getTasks: GetTasks
)