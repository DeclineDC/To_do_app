package com.example.to_doapp.app_features.presentation.add_edit_task_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.to_doapp.ui.theme.LocalSpacing

@Composable
fun SwitchRow(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {

    val spacing = LocalSpacing.current

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = spacing.spaceLarge,
                    end = spacing.space12,
                    top = spacing.space12,
                    bottom = spacing.spaceSmall
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Send Notifications",
                modifier = Modifier.offset(y = 10.dp),
                style = MaterialTheme.typography.body1
            )
            Switch(
                checked = isChecked,
                onCheckedChange = onCheckedChange,
                colors = SwitchDefaults.colors(
                    checkedTrackColor = MaterialTheme.colors.secondary,
                    checkedThumbColor = Color.White,
                    uncheckedThumbColor = Color.White,
                    uncheckedTrackColor = Color.LightGray,
                )
            )

        }
        Divider(
            thickness = 1.dp,
            modifier = Modifier.padding(start = 12.dp, top = 0.dp, end = 12.dp, bottom = 0.dp)
        )
        Row(
            modifier = Modifier
                .padding(
                    start = spacing.spaceLarge,
                    end = spacing.space12,
                    top = spacing.space12,
                    bottom = spacing.spaceSmall
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Repeat Task",
                modifier = Modifier.offset(y = 10.dp),
                style = MaterialTheme.typography.body1
            )
            Switch(
                checked = true,
                onCheckedChange = onCheckedChange,
                colors = SwitchDefaults.colors(
                    checkedTrackColor = MaterialTheme.colors.secondary,
                    checkedThumbColor = Color.White,
                    uncheckedThumbColor = Color.White,
                    uncheckedTrackColor = Color.LightGray
                )
            )

        }
    }

}