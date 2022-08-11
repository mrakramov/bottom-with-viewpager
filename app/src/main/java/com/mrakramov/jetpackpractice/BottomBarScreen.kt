package com.mrakramov.jetpackpractice

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {

    object Main : BottomBarScreen(
        route = "main_screen",
        title = "main",
        icon = Icons.Default.Home
    )

    object Home : BottomBarScreen(
        route = "home_screen",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Profile : BottomBarScreen(
        route = "profile_screen",
        title = "Profile",
        icon = Icons.Default.Person
    )

    object Settings : BottomBarScreen(
        route = "setting_screen",
        title = "Settings",
        icon = Icons.Default.Settings
    )
}