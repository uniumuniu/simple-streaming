package com.uniumuniu.simplestreaming.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.uniumuniu.simplestreaming.presentation.events.EventsScreen
import com.uniumuniu.simplestreaming.presentation.playback.PlaybackScreen
import com.uniumuniu.simplestreaming.presentation.playback.PlaybackViewModel
import com.uniumuniu.simplestreaming.presentation.schedule.ScheduleScreen
import com.uniumuniu.simplestreaming.presentation.tabs.TabItem
import com.uniumuniu.simplestreaming.ui.theme.SimpleStreamingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleStreamingTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val tabs = listOf(
                        TabItem.Events,
                        TabItem.Schedule
                    )

                    val navController = rememberNavController()
                    Scaffold(
                        bottomBar = {
                            val navBackStackEntry = navController.currentBackStackEntryAsState()
                            val currentDestination = navBackStackEntry.value?.destination
                            if (currentDestination?.route == Screen.EventsScreen.route ||
                                currentDestination?.route == Screen.ScheduleScreen.route
                            ) {
                                BottomNavigation {
                                    tabs.forEach { screen ->
                                        BottomNavigationItem(
                                            icon = { Icon(screen.icon, null) },
                                            label = {
                                                Text(
                                                    screen.title,
                                                    modifier = Modifier.padding(top = 4.dp)
                                                )
                                            },
                                            selected = currentDestination.hierarchy.any { it.route == screen.route },
                                            selectedContentColor = Color.White,
                                            unselectedContentColor = Color.White.copy(alpha = 0.5f),
                                            onClick = {
                                                navController.navigate(screen.route) {
                                                    // Pop up to the start destination of the graph to
                                                    // avoid building up a large stack of destinations
                                                    // on the back stack as users select items
                                                    popUpTo(navController.graph.findStartDestination().id) {
                                                        saveState = true
                                                    }
                                                    // Avoid multiple copies of the same destination when
                                                    // reselecting the same item
                                                    launchSingleTop = true
                                                    // Restore state when reselecting a previously selected item
                                                    restoreState = true
                                                }
                                            }
                                        )
                                    }
                                }
                            }
                        }
                    ) { innerPadding ->
                        NavHost(
                            navController,
                            startDestination = Screen.EventsScreen.route,
                            Modifier.padding(innerPadding)
                        ) {
                            composable(Screen.EventsScreen.route) { EventsScreen(navController = navController) }
                            composable(Screen.ScheduleScreen.route) { ScheduleScreen() }
                            composable(
                                Screen.PlaybackScreen.route + "/{videoUrl}"
                            ) {
                                val viewModel: PlaybackViewModel = hiltViewModel()
                                PlaybackScreen(viewModel)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SimpleStreamingTheme {

    }
}