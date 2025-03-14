package com.example.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavController) {
    Scaffold (
        modifier = Modifier.windowInsetsPadding(WindowInsets.statusBars),
        topBar = {TopBar()},
        bottomBar = {BottomNavigation()}
    ){ innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(Color(0xFFF2F2F2)).padding(innerPadding)
        ) {

            SearchBar()
            PopulationCard()
            SuratPengantarRTCard()
            ServicesSection()
            InformationSection()
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun TopBar() {
    Card(

        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(0.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text("SI TALKER", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text("Hai, Selamat Datang !", fontSize = 14.sp, color = Color.Gray)
                Text("Di Layanan Kelurahan Talang Keramat", fontSize = 12.sp, color = Color.Gray)
            }
            IconButton(
                onClick = { },
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.White)
            ) {
                Icon(
                    Icons.Filled.Notifications,
                    contentDescription = "Notifications",
                    tint = Color.Black
                )
            }
        }
    }
}

@Composable
fun SearchBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Cari", color = Color.Gray) },
            trailingIcon = {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = "Search",
                    tint = Color.Gray
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE6E6E6), RoundedCornerShape(24.dp)),
            shape = RoundedCornerShape(24.dp)
        )
    }
}

@Composable
fun PopulationCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                "PENDUDUK TALANG KERAMAT",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                PopulationStat("Total Penduduk", "0")

                Box(
                    modifier = Modifier
                        .height(60.dp)
                        .width(1.dp)
                        .background(Color.LightGray)
                )

                PopulationStat("Laki-laki", "0", true)

                Box(
                    modifier = Modifier
                        .height(60.dp)
                        .width(1.dp)
                        .background(Color.LightGray)
                )

                PopulationStat("Perempuan", "0", true)
            }
        }
    }
}

@Composable
fun PopulationStat(label: String, value: String, showIcon: Boolean = false) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            label,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )

        if (showIcon) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    Icons.Default.Person,
                    contentDescription = label,
                    modifier = Modifier.size(16.dp),
                    tint = Color.Gray
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    value,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        } else {
            Text(
                value,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun SuratPengantarRTCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFEEEEEE)),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Document icon placeholder
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.White, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Document",
                    tint = Color.Gray
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                "Surat Pengantar RT",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.weight(1f))

            // Edit icon placeholder
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(Color.Transparent),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Edit",
                    tint = Color.Gray
                )
            }
        }
    }
}

@Composable
fun ServicesSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            "PELAYANAN",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        // First row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ServiceItem("DOMISILI")
            ServiceItem("KELAHIRAN")
            ServiceItem("KEMATIAN")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Second row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ServiceItem("PINDAH")
            ServiceItem("PERNIKAHAN")
            ServiceItem("AHLI WARIS")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Third row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ServiceItem("TIDAK MAMPU")
            ServiceItem("USAHA")
            ServiceItem("LAINNYA")
        }
    }
}

@Composable
fun ServiceItem(title: String) {
    Card(
        modifier = Modifier
            .size(100.dp, 80.dp)
            .padding(4.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                title,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun InformationSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Info",
                    tint = Color.Gray,
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    "INFORMASI",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                "Pastikan semua dokumen telah di cek 2x sebelum melakukan pengajuan pelayanan!",
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun BottomNavigation(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Home
            IconButton(onClick = { }) {
                Icon(
                    Icons.Default.Home,
                    contentDescription = "Home",
                    tint = Color.Gray
                )
            }

            // Profile
            IconButton(onClick = { }) {
                Icon(
                    Icons.Default.Person,
                    contentDescription = "Profile",
                    tint = Color.Gray
                )
            }

            // QR Code (placeholder)
            IconButton(onClick = { }) {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "QR Code",
                    tint = Color.Gray
                )
            }

            // Settings (placeholder)
            IconButton(onClick = { }) {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "Settings",
                    tint = Color.Gray
                )
            }
        }
    }
}

@Preview
@Composable
fun BerandaPreview(){
    MainScreen(rememberNavController())
}