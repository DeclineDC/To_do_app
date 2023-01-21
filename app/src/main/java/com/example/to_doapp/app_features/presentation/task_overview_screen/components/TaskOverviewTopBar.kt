package com.example.to_doapp.app_features.presentation.task_overview_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.Bottom,
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.1f)
            .background(color = MaterialTheme.colors.primary)
            .padding(start = 12.dp, top = 32.dp, end = 12.dp, bottom = 12.dp)
    ) {
        Row(modifier = Modifier.fillMaxHeight()) {
            Text(text = "Task Overview")
            Spacer(modifier = Modifier.padding(47.dp))
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = stringResource(id = R.string.cancel),
                modifier = Modifier.clickable {
                    onAddClick()
                }
            )
        }
    }

}
