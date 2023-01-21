package com.example.to_doapp.app_features.presentation.add_edit_task_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.to_doapp.ui.theme.LocalSpacing

@Composable
fun DateCardForm(
    value: String,
    isEditable: Boolean,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier,
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
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = spacing.space12,
                        end = spacing.space12,
                        top = spacing.space12,
                        bottom = spacing.spaceSmall
                    )
            ) {
                Text(text = "Task Due By", modifier = Modifier.offset(x = 13.dp))
                TextField(
                    value = value,
                    onValueChange = onValueChange,
                    keyboardOptions = keyboardOptions,
                    readOnly = !isEditable,
                    singleLine = true,
                    textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = null
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.primary,
                        focusedIndicatorColor = MaterialTheme.colors.primary,
                        unfocusedIndicatorColor = MaterialTheme.colors.primary,
                        cursorColor = MaterialTheme.colors.onPrimary
                    ), modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }

}