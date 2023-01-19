package com.example.to_doapp.app_features.presentation.add_edit_task_screen

sealed class AddEditTaskEvent {

    object OnSaveTask : AddEditTaskEvent()
}