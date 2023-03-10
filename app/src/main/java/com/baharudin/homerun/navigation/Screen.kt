package com.baharudin.homerun.navigation

sealed class Screen(val route : String) {
    object Splash : Screen(route = "splash_screen")
    object Main : Screen(route = "main_screen")
}
