package com.mrakramov.jetpackpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.mrakramov.jetpackpractice.screens.HomeScreen
import com.mrakramov.jetpackpractice.screens.MainScreen
import com.mrakramov.jetpackpractice.screens.ProfileScreen
import com.mrakramov.jetpackpractice.screens.SettingScreen
import com.mrakramov.jetpackpractice.ui.theme.JetpackPracticeTheme
import com.ramcosta.composedestinations.rememberNavHostEngine

@ExperimentalPagerApi
@ExperimentalMotionApi
@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavHostEngine().rememberNavController()

            JetpackPracticeTheme {
                NavHost(
                    navController = navController,
                    startDestination = BottomBarScreen.Main.route,
                ) {
                    composable(BottomBarScreen.Main.route) {
                        MainScreen(navController)
                    }
                    composable(BottomBarScreen.Home.route) {
                        HomeScreen(navController)
                    }
                    composable(BottomBarScreen.Settings.route) {
                        SettingScreen()
                    }
                    composable(BottomBarScreen.Profile.route) {
                        ProfileScreen()
                    }
                }
            }
        }
    }
}