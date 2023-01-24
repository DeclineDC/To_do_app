package com.example.to_doapp.app_features.presentation.task_detail_screen

import com.example.to_doapp.app_features.domain.model.Task

sealed class TaskDetailEvent {

    data class OnDeleteTask(val task: Task) : TaskDetailEvent()
    object OnCompleteTask : TaskDetailEvent()
}