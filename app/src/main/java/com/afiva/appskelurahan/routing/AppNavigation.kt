package com.afiva.appskelurahan.routing

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.afiva.appskelurahan.ui.screens.loginScreen
import com.example.ui.BerandaScreen
import androidx.navigation.compose.composable

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) {
            loginScreen(navController)
        }
        composable(Screen.Beranda.route) {
            BerandaScreen(navController)
        }
    }
}
