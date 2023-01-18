package com.example.to_doapp.app_features.presentation.task_overview_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.to_doapp.R
import com.example.to_doapp.ui.theme.Cyan
import com.example.to_doapp.ui.theme.LocalSpacing

@Composable
fun TaskOverviewTopBar(
    onAddClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.primary)
    ) {
        Row() {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Person,
                    tint = Cyan,
                    modifier = modifier.size(spacing.spaceLarge),
                    contentDescription = stringResource(R.string.icon),
                )
            }

        }
        Text(
            text = stringResource(R.string.tasks),
            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
            color = Color.Black,
            modifier = Modifier.offset(y = 10.dp)
        )
        IconButton(
            onClick = onAddClick,
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                tint = Cyan,
                modifier = modifier.size(spacing.spaceLarge),
                contentDescription = stringResource(R.string.add),
            )
        }
    }

}
