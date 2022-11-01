package com.mrakramov.jetpackpractice.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mrakramov.jetpackpractice.screens.destinations.BottomHolderScreenDestination
import com.mrakramov.jetpackpractice.screens.destinations.DetailScreenDestination
import com.ramcosta.composedestinations.annotation.Destination

const val BASE = "https://a-pay.uz"
const val ARG = "message"

@Composable
@Destination
fun HolderScreen(parentNavController: NavController) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = BottomHolderScreenDestination.route
    ) {
        composable(BottomHolderScreenDestination.route) {
            BottomHolderScreen(
                navController

            )
        }
        composable(
            DetailScreenDestination.route,
            arguments = DetailScreenDestination.arguments,
            deepLinks = DetailScreenDestination.deepLinks
        ) {
            val arguments = it.arguments
            arguments?.getString(ARG)?.let { message ->
                DetailScreen(message)
            }
        }
    }
}
