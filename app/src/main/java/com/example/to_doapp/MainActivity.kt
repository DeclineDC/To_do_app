package com.example.to_doapp

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.to_doapp.app_features.presentation.TaskBottomNavBar
import com.example.to_doapp.app_features.presentation.add_edit_task_screen.AddEditTaskScreen
import com.example.to_doapp.app_features.presentation.task_detail_screen.TaskDetailScreen
import com.example.to_doapp.app_features.presentation.task_overview_screen.TaskOverviewScreen
import com.example.to_doapp.app_features.presentation.util.Screen
import com.example.to_doapp.ui.theme.LocalSpacing
import com.example.to_doapp.ui.theme.ToDoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoAppTheme {

                val navController = rememberNavController()


                val spacing = LocalSpacing.current

                val screens = listOf(
                    Screen.AddEditTaskScreen,
                    Screen.TaskOverviewScreen,
                    Screen.TaskDetailScreen
                )


                val showBottomBar =
                    navController.currentBackStackEntryAsState().value?.destination?.route in screens.map { it.route }


                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        TaskBottomNavBar(
                            showBottomBar = showBottomBar,
                            onHomeClick = { navController.navigate(Screen.TaskOverviewScreen.route) },
                            onCompletedTasksClick = {})
                    },
                    isFloatingActionButtonDocked = true,
                    floatingActionButton = {
                        com.example.to_doapp.app_features.presentation.FloatingActionButton(
                            showBottomBar
                        ) {
                            navController.navigate(
                                Screen.AddEditTaskScreen.route
                            )
                        }
                    },
                    floatingActionButtonPosition = FabPosition.Center
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
                            route = Screen.AddEditTaskScreen.route +
                                    "?taskId={taskId}",
                            arguments = listOf(
                                navArgument(
                                    name = "taskId"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                }
                            )
                        ) {
                            AddEditTaskScreen(navController = navController)
                        }
                        composable(
                            route = Screen.TaskDetailScreen.route +
                                    "?taskId={taskId}",
                            arguments = listOf(
                                navArgument(
                                    name = "taskId"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                }
                            )
                        ) {
                            TaskDetailScreen(navController = navController)
                        }
                    }

                }

            }
        }
    }
}
