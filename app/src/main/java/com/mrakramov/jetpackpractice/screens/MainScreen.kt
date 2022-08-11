package com.mrakramov.jetpackpractice.screens

import android.app.Activity
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.mrakramov.jetpackpractice.BottomBarScreen
import com.mrakramov.jetpackpractice.screens.destinations.HomeScreenDestination
import com.mrakramov.jetpackpractice.screens.destinations.MainScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
@Destination(start = true)
fun MainScreen(navController: NavController) {

    val rememberCoroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState()
    val current = LocalContext.current

    BackHandler {
        if (pagerState.currentPage != 0) rememberCoroutineScope.launch { pagerState.scrollToPage(0) }
        else ( current as? Activity)?.finishAffinity()
    }

    val items = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Profile,
        BottomBarScreen.Settings,
        BottomBarScreen.Settings,
    )


    com.google.accompanist.insets.ui.Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
        BottomNavigation(
            backgroundColor = Color.White
        ) {
            items.forEachIndexed { index, item ->
                BottomNavigationItem(
                    icon = { Icon(item.icon, contentDescription = null) },
                    label = { Text(item.title) },
                    selectedContentColor = Color.Red,
                    unselectedContentColor = Color.Gray.copy(0.8f),
                    onClick = {
                        rememberCoroutineScope.launch {
                            pagerState.scrollToPage(index)
                        }
                    },
                    selected = pagerState.currentPage == index,
                )
            }
        }
    }) {
        HorizontalPager(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 56.dp),
            count = 4,
            state = pagerState,
            userScrollEnabled = false,

            ) {
            when (currentPage) {
                0 -> {
                    HomeScreen(navController)
                }
                1 -> {
                    ProfileScreen()
                }
                2 -> {
                    SettingScreen()
                }
                3 -> {
                    SettingScreen()
                }
            }
        }
    }
}