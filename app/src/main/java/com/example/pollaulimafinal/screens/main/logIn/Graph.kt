package com.example.pollaulimafinal.screens.main.logIn

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pollaulimafinal.screens.main.MainScreen

@Composable
fun Graph(
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit,
    navigateToDetail: (Int) -> Unit,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.LogIn.route
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = Screen.LogIn.route) {
            LogIn(navController)
        }

        composable(route = Screen.MainScreen.route) {
            MainScreen()
        }
    }
}
