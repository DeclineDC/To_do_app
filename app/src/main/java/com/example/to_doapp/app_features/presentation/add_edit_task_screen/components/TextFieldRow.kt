package com.example.to_doapp.app_features.presentation.add_edit_task_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.to_doapp.ui.theme.LocalSpacing

@Composable
fun TextFieldRow(
    text: String,
    value: String,
    color: Color,
    isEditable: Boolean,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier,
    trailingIcon: @Composable() () -> Unit = {},
) {
    val spacing = LocalSpacing.current

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.h4,
            softWrap = false,
            modifier = Modifier
                .padding(start = spacing.spaceMedium)
                .weight(.25f)
        )
        TextField(
            modifier = Modifier
                .padding(end = spacing.spaceMedium)
                .weight(.75f)
                .offset(y = (-5).dp),
            readOnly = !isEditable,
            singleLine = true,
            value = value,
            keyboardOptions = keyboardOptions,
            onValueChange = onValueChange,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.surface,
                focusedIndicatorColor = color,
            ),
            trailingIcon = trailingIcon
        )

    }

}