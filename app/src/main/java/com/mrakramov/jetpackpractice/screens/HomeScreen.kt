package com.mrakramov.jetpackpractice.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.mrakramov.jetpackpractice.screens.destinations.DetailScreenDestination
import com.mrakramov.jetpackpractice.screens.destinations.HolderScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.navigate

@Composable
@Destination
fun HomeScreen(parentNavController: NavController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        TextButton(onClick = {
            parentNavController.navigate(DetailScreenDestination(""))
        }) {
            Text(text = "Home Screen")
        }
    }
}