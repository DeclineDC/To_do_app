package com.example.to_doapp.app_features.presentation.add_edit_task_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.to_doapp.ui.theme.LocalSpacing

@Composable
fun SwitchCardForm(
    isNotifyingChecked: Boolean,
    onNotifyingCheckedChange: (Boolean) -> Unit,
    isRepeatableChecked: Boolean,
    onRepeatableCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {

    val spacing = LocalSpacing.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(spacing.space12)
    ) {
        Card(
            shape = RoundedCornerShape(spacing.spaceMedium),
            elevation = 1.dp,
            backgroundColor = MaterialTheme.colors.primary,
        ) {

            SwitchRow(
                isNotifyingChecked = isNotifyingChecked,
                onNotifyingCheckedChange = onNotifyingCheckedChange,
                isRepeatableChecked = isRepeatableChecked,
                onRepeatableCheckedChange = onRepeatableCheckedChange
            )

        }

    }
}
