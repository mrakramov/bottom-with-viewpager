package com.mrakramov.jetpackpractice.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mrakramov.jetpackpractice.BottomBarScreen
import com.ramcosta.composedestinations.annotation.Destination

@Composable
@Destination
fun HomeScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize(), contentAlignment = Alignment.BottomCenter
    ) {

        TextButton(onClick = { navController.navigate(BottomBarScreen.Settings.route) }) {
            Text(text = "Click me")
        }

    }


}