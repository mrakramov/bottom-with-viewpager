package com.mrakramov.jetpackpractice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mrakramov.jetpackpractice.screens.*
import com.mrakramov.jetpackpractice.screens.destinations.HolderScreenDestination
import com.mrakramov.jetpackpractice.screens.destinations.SplashScreenDestination
import com.mrakramov.jetpackpractice.ui.theme.JetpackPracticeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val parenNavController = rememberNavController()

            JetpackPracticeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    NavHost(
                        navController = parenNavController,
                        startDestination = SplashScreenDestination.route,
                    ) {
                        composable(HolderScreenDestination.route) {
                            HolderScreen(parentNavController = parenNavController)
                        }
                        composable(
                            SplashScreenDestination.route,
                        ) {
                            SplashScreen(parenNavController)
                        }
                    }
                }
            }
        }
    }
}