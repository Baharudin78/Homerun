package com.baharudin.homerun.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.baharudin.homerun.page.HomeScreen
import com.baharudin.homerun.page.SplashScreen

@Composable
fun SetupNavGraph(navHostController: NavHostController){
    NavHost(
        navController = navHostController,
        startDestination = Screen.Splash.route
    ){
        composable(route = Screen.Splash.route){
            SplashScreen(navHostComposable = navHostController)
        }
        composable(route = Screen.Main.route){
            HomeScreen()
        }
    }
}