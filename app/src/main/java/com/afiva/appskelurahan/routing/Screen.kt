package com.afiva.appskelurahan.routing

sealed class Screen(val route:String){
    object Login : Screen("login")
    object Beranda : Screen("beranda")
}