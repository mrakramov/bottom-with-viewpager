package com.mrakramov.jetpackpractice.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ui.BottomNavigation
import com.google.accompanist.insets.ui.Scaffold
import com.mrakramov.jetpackpractice.BottomBarScreen
import com.mrakramov.jetpackpractice.screens.destinations.HomeScreenDestination
import com.mrakramov.jetpackpractice.screens.destinations.ProfileScreenDestination
import com.ramcosta.composedestinations.annotation.Destination

@Composable
@Destination
fun BottomHolderScreen(parentNavController: NavController) {
    val navController = rememberNavController()

    val items = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Profile,
    )
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                        label = { Text(screen.title) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = HomeScreenDestination.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(HomeScreenDestination.route) {
                HomeScreen(parentNavController)
            }
            composable(ProfileScreenDestination.route) {
                ProfileScreen()
            }
        }
    }
}