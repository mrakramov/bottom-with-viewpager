package com.mrakramov.jetpackpractice.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.mrakramov.jetpackpractice.screens.destinations.HolderScreenDestination
import com.ramcosta.composedestinations.annotation.DeepLink
import com.ramcosta.composedestinations.annotation.Destination
import kotlinx.coroutines.delay

@Composable
@Destination(start = true)
fun SplashScreen(parenNavController: NavController) {

    LaunchedEffect(Unit) {
        delay(1000L)
        parenNavController.navigate(HolderScreenDestination.route)
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        TextButton(onClick = {
        }) {
            Text(text = "Splash Screen")
        }
    }
}