package com.example.to_doapp.app_features.presentation.add_edit_task_screen

import java.time.LocalDate

sealed class AddEditTaskEvent {


    data class OnTitleChange(val value: String) : AddEditTaskEvent()
    data class OnDescriptionChange(val value: String) : AddEditTaskEvent()
    data class OnDateChange(val localDate: LocalDate) : AddEditTaskEvent()
    object OnSaveTask : AddEditTaskEvent()
    object OnCancelClick : AddEditTaskEvent()
    object OnRepeatableSelected : AddEditTaskEvent()
    object OnNotifyingSelected : AddEditTaskEvent()


}