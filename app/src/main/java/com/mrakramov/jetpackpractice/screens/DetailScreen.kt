package com.mrakramov.jetpackpractice.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.navDeepLink

import com.ramcosta.composedestinations.annotation.DeepLink
import com.ramcosta.composedestinations.annotation.Destination


@Composable
@Destination(
    deepLinks = [DeepLink(uriPattern = "${BASE}/${ARG}={message}")]
)
fun DetailScreen(message: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        TextButton(onClick = {
        }) {
            Text(text = "Detail Screen: $message")
        }
    }
}