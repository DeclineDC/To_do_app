package com.example.to_doapp.app_features.presentation.util

sealed class UiEvent {

    data class ShowSnackBar(val message: String) : UiEvent()

    object SaveTask : UiEvent()

    object OnCancelClick : UiEvent()

}
