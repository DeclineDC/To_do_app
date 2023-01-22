package com.example.to_doapp.app_features.presentation.task_overview_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.to_doapp.app_features.presentation.task_overview_screen.TaskOverviewViewModel
import com.example.to_doapp.ui.theme.LocalSpacing

@Composable
fun TasksContainer(
    modifier: Modifier = Modifier,
    viewModel: TaskOverviewViewModel
) {

    val spacing = LocalSpacing.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = spacing.space12, end = spacing.space12, bottom = 0.dp, top = 0.dp),
        shape = RoundedCornerShape(spacing.spaceMedium),
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Column(modifier = Modifier.background(MaterialTheme.colors.primary)) {
            LazyColumn(modifier = Modifier.height(190.dp)) {
                items(viewModel.state.tasks) { task ->
                    TaskItem(
                        task = task,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                    )
                }
            }
        }

    }

}