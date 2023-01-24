package com.example.to_doapp.app_features.presentation.add_edit_task_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.to_doapp.R
import com.example.to_doapp.ui.theme.Cyan
import com.example.to_doapp.ui.theme.LocalSpacing


@Composable
fun AddEditTaskTopBar(
    onAddClick: () -> Unit,
    onDeleteClick: () -> Unit,
    onCancelClick: () -> Unit,
    isExistingTask: Boolean = false,
    modifier: Modifier = Modifier
) {

    val spacing = LocalSpacing.current

    Row(
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.Bottom,
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.1f)
            .background(color = MaterialTheme.colors.primary)
            .padding(start = 12.dp, top = 32.dp, end = 12.dp, bottom = 12.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Box() {}
            Text(
                text = if (isExistingTask) "Edit Task" else "New Task",
                style = MaterialTheme.typography.h2,
                color = MaterialTheme.colors.onPrimary
            )
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = stringResource(id = R.string.cancel),
                tint = MaterialTheme.colors.onPrimary,
                modifier = Modifier.clickable {
                    onCancelClick()
                }
            )
        }
    }
}
