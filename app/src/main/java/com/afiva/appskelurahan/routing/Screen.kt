package com.afiva.appskelurahan.routing

sealed class Screen(val route:String){
    object Login : Screen("login")
    object Beranda : Screen("beranda")
    object ScreenBaru : Screen("screen_baru")
    object ProfilScreen : Screen("profile-screen")
    object FormPengantarRT : Screen("Form-Pengantar")
    object SuratKeteranganTidakMampu : Screen("surat-keterangan-tidak-mampu")


}