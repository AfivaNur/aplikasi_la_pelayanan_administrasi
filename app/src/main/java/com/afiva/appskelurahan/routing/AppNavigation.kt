package com.afiva.appskelurahan.routing

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.afiva.appskelurahan.ui.screens.ProfileScreen
import com.afiva.appskelurahan.ui.screens.SuratKeteranganTidakMampu
import com.afiva.appskelurahan.ui.screens.SuratPengantarForm
import com.afiva.appskelurahan.ui.screens.loginScreen
import com.example.ui.MainScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.SuratKeteranganTidakMampu.route) {

        composable(Screen.Beranda.route) {
            MainScreen(navController)
        }

        composable(Screen.Login.route) {
            loginScreen(navController)
        }

        composable(Screen.ProfilScreen.route) {
            ProfileScreen()

        }
        composable(Screen.FormPengantarRT.route) {
            SuratPengantarForm()

        }

        composable(Screen.SuratKeteranganTidakMampu.route) {
            SuratKeteranganTidakMampu()
        }
    }
}
