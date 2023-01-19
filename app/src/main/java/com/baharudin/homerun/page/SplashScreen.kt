package com.baharudin.homerun.page

import android.window.SplashScreen
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import com.baharudin.homerun.R
import com.baharudin.homerun.navigation.Screen

@Composable
fun SplashScreen(
    navHostComposable: NavHostController
) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnimation = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 2000
        )
    )
    LaunchedEffect(key1 = true ) {
        startAnimation = true
        delay(3000)
        navHostComposable.popBackStack()
        navHostComposable.navigate(Screen.Main.route)
    }
    SplashView(alphe = alphaAnimation.value)
}

@Composable
fun SplashView(alphe : Float){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.logocorrect),
            contentDescription = "splash",
            modifier = Modifier
                .size(120.dp)
                .alpha(alpha = alphe)
        )
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun SplashPrev(){
    SplashView(alphe = 1f)
}