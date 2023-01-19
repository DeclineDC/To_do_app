package com.example.to_doapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.to_doapp.app_features.presentation.add_edit_task_screen.AddEditTaskScreen
import com.example.to_doapp.app_features.presentation.task_overview_screen.TaskOverviewScreen
import com.example.to_doapp.app_features.presentation.util.Screen
import com.example.to_doapp.ui.theme.LocalSpacing
import com.example.to_doapp.ui.theme.ToDoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoAppTheme {

                val navController = rememberNavController()
                val spacing = LocalSpacing.current

                TaskOverviewScreen(navController = navController)

                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Screen.TaskOverviewScreen.route
                    ) {
                        composable(
                            route = Screen.TaskOverviewScreen.route
                        ) {
                            TaskOverviewScreen(navController = navController)
                        }
                        composable(
                            route = Screen.AddEditTaskScreen.route
                        ) {
                            AddEditTaskScreen(navController = navController)
                        }
                    }

                }

            }
        }
    }
}
