package com.mrakramov.jetpackpractice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
//            var isSearchEnabled by remember {
//                mutableStateOf(true)
//            }
//
//            val state = remember {
//                MutableTransitionState(true).apply {
//                    targetState = false
//                }
//            }
//
//            val slow = 2000
//            Column(
//                modifier = Modifier
//                    .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .fillMaxHeight(0.1f)
//                        .background(Color(0xFF16B364)), contentAlignment = Alignment.Center
//                ) {
//                    Text(text = "Pechat fiksal chek", modifier = Modifier.clickable {
//                        isSearchEnabled = !isSearchEnabled
//                    }, color = Color.White, fontSize = 18.sp)
//                }
//                Box(
//                    Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
//                ) {
//                    Box(
//                        modifier = Modifier
//                            .align(Alignment.TopCenter)
//                            .fillMaxWidth()
//                            .height(30.dp)
//                            .clip(RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp))
//                            .background(Color(0xff16B364))
//                    )
//                    Box(
//                        modifier = Modifier.fillMaxWidth(0.8f), contentAlignment = Alignment.Center
//                    ) {
//                        androidx.compose.animation.AnimatedVisibility(
//                            enter = expandVertically(
//                                expandFrom = Alignment.Bottom, animationSpec = tween(
//                                    durationMillis = slow,
//                                    easing = FastOutLinearInEasing,
//                                )
//                            ), exit = shrinkVertically(
//                                shrinkTowards = Alignment.Bottom, animationSpec = tween(
//                                    durationMillis = slow,
//                                    easing = FastOutLinearInEasing,
//                                )
//                            ),
//                            visibleState = state
//                        ) {
//                            Card(
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .padding(
//                                        end = 10.dp,
//                                        start = 10.dp,
//                                        top = 5.dp
//                                    ),
//                                shape = RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp)
//                            ) {
//                                Column(
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .background(Color.White)
//                                        .padding(10.dp)
//                                ) {
//                                    ItemCheck()
//                                    ItemCheck()
//                                    ItemCheck()
//                                    ItemCheck()
//                                    ItemCheck()
//                                    ItemCheck()
//                                    ItemCheck()
//                                    Divider()
//                                    ItemCheck()
//                                    ItemCheck()
//                                    ItemCheck()
//                                    ItemCheck()
//                                }
//
//                            }
//                        }
//                        Box(
//                            modifier = Modifier
//                                .align(Alignment.TopCenter)
//                                .fillMaxWidth()
//                                .height(10.dp)
//                                .clip(RoundedCornerShape(8.dp))
//                                .background(
//                                    brush = Brush.verticalGradient(
//                                        colors = listOf(
//                                            Color(0xFF0D7340).copy(0.8f),
//                                            Color(0xFF0D7340).copy(0.1f)
//                                        )
//                                    )
//                                )
//                        )
//
//                    }
//                }
//
//                Spacer(modifier = Modifier.weight(1f))
//                if (state.currentState) {
//                    CircularProgressIndicator()
//                }
//                AnimatedVisibility(visible = !state.currentState) {
//                    Column(
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        verticalArrangement = Arrangement.Bottom
//                    ) {
//                        Button(onClick = { /*TODO*/ }) {
//                            Text(text = "Button 1")
//                        }
//                        Button(onClick = { /*TODO*/ }) {
//                            Text(text = "Button 1")
//                        }
//                        Button(onClick = { /*TODO*/ }) {
//                            Text(text = "Button 1")
//                        }
//                    }
//
//                }
//
//            }
        }
    }

    @Composable
    private fun ItemCheck() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Text(text = "Something:")
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "1565165")
        }
    }
}