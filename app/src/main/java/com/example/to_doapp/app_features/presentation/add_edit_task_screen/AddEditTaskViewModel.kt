package com.example.to_doapp.app_features.presentation.add_edit_task_screen

import androidx.lifecycle.ViewModel
import com.example.to_doapp.app_features.domain.use_case.TaskUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddEditTaskViewModel @Inject constructor(
    private val taskUseCases: TaskUseCases
) : ViewModel() {
}