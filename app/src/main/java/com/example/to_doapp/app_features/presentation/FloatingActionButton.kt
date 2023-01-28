package com.example.to_doapp.app_features.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.to_doapp.app_features.presentation.util.Screen

@Composable
fun FloatingActionButton(
    showFloatingActionButton: Boolean,
    onClick: () -> Unit
) {

    val screens = listOf(
        Screen.AddEditTaskScreen,
        Screen.TaskOverviewScreen,
        Screen.TaskDetailScreen
    )


    AnimatedVisibility(visible = showFloatingActionButton) {


        androidx.compose.material.FloatingActionButton(
            onClick = { },
            shape = CircleShape,
            modifier = Modifier
                .offset(y = 16.dp)
                .size(64.dp),
            backgroundColor = MaterialTheme.colors.primary,
            elevation = FloatingActionButtonDefaults.elevation(0.dp)
        ) {
            IconButton(
                onClick = { onClick() }, modifier = Modifier
                    .fillMaxSize()
                    .padding(6.dp)
                    .border(
                        width = 2.5.dp,
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFF11998e),
                                Color(0xFF38ef7d),
                                MaterialTheme.colors.secondary
                            )
                        ),
                        shape = CircleShape
                    )
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp),
                    tint = Color.Gray
                )
            }
        }
    }
}