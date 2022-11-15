package com.example.pollaulimafinal.screens.main.logIn

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination


sealed class Screen(val route: String) {
    object LogIn: Screen("logIn")
    object MainScreen: Screen("MainScreen")
    object detailScreen: Screen("detailScreen")
    object polla: Screen("polla")
}



