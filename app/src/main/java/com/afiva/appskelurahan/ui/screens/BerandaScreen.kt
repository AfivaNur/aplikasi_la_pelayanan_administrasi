package com.example.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.afiva.appskelurahan.R

@Composable
fun BerandaScreen(navController: NavController) {
    Scaffold (bottomBar = {
        BottomNavigationBar()
    }){ innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize().padding(innerPadding)
                .background(Color.White).verticalScroll(rememberScrollState())
        ) {
            TopBar()
            SearchBar()
            BannerSection()
            Spacer(modifier = Modifier.height(16.dp))
            CategoryGrid()
            Spacer(modifier = Modifier.height(16.dp))
            TutorialSection()
            Spacer(modifier = Modifier.weight(1f))

        }
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            // Use Text instead of Image for the logo to avoid resource issues
            Text(
                text = "LaTalKer",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2196F3),
                modifier = Modifier.padding(vertical = 16.dp) // Jarak atas & bawah 16dp
            )

            Text(
                "Hai, Selamat Datang!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )
            Text(
                text = "Di Layanan Kelurahan Talang Keramat",
                fontSize = 14.sp,
                color = Color.Gray,
            )

        }

        // Use IconButton with a basic Icon to avoid resource issues
        IconButton(
            onClick = { /* Help Action */ },
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.White)
        ) {
            Icon(
                imageVector = androidx.compose.material.icons.Icons.Default.Info,
                contentDescription = "Help",
                tint = Color.Gray
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        placeholder = { Text("Lagi mau bikin surat apa?", color = Color.LightGray) },
        leadingIcon = {
            Icon(
                imageVector = androidx.compose.material.icons.Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.Gray
            )
        },
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.LightGray,
            focusedBorderColor = Color(0xFF2196F3)
        ),
        singleLine = true
    )
}

@Composable
fun BannerSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFF2196F3))
    ) {
        // Create a placeholder banner instead of using Image resource
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(2f),
                verticalArrangement = Arrangement.Center
            ) {
                // Step 1
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 4.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("1", fontWeight = FontWeight.Bold, color = Color(0xFF2196F3))
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Tambahkan akun", color = Color.White, fontWeight = FontWeight.Medium)
                }

                // Connector line
                Box(
                    modifier = Modifier
                        .width(2.dp)
                        .height(8.dp)
                        .background(Color.White)
                        .padding(start = 20.dp)
                )

                // Step 2
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 4.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("2", fontWeight = FontWeight.Bold, color = Color(0xFF2196F3))
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Pilih template", color = Color.White, fontWeight = FontWeight.Medium)
                }

                // Connector line
                Box(
                    modifier = Modifier
                        .width(2.dp)
                        .height(8.dp)
                        .background(Color.White)
                        .padding(start = 20.dp)
                )

                // Step 3
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 4.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("5", fontWeight = FontWeight.Bold, color = Color(0xFF2196F3))
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Surat selesai", color = Color.White, fontWeight = FontWeight.Medium)
                }
            }

            // Right side image placeholder
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.3f))
                )
            }
        }
    }
}

@Composable
fun CategoryGrid() {
    // kategori ikon/ fitur layanan
    val categories = listOf(
        Triple("Sekolah", androidx.compose.material.icons.Icons.Default.Home, Color(0xFFF5F5F5)),
        Triple("Pekerjaan", androidx.compose.material.icons.Icons.Default.Home, Color(0xFFF5F5F5)),
        Triple("Desa", androidx.compose.material.icons.Icons.Default.Home, Color(0xFFF5F5F5)),
        Triple("Bisnis", androidx.compose.material.icons.Icons.Default.Home, Color(0xFFF5F5F5)),
        Triple("Umum", androidx.compose.material.icons.Icons.Default.Home, Color(0xFFF5F5F5)),
        Triple("Keuangan", androidx.compose.material.icons.Icons.Default.Home, Color(0xFFF5F5F5)),
        Triple("Pribadi", androidx.compose.material.icons.Icons.Default.Home, Color(0xFFF5F5F5)),
        Triple("Kesehatan", androidx.compose.material.icons.Icons.Default.Home, Color(0xFFF5F5F5))
    )

    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            for (i in 0..3) {
                CategoryItemWithVector(categories[i])
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            for (i in 4..7) {
                CategoryItemWithVector(categories[i])
            }
        }
    }
}

// Updated CategoryItem to use vector icons
@Composable
fun CategoryItemWithVector(category: Triple<String, androidx.compose.ui.graphics.vector.ImageVector, Color>) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(80.dp)
    ) {
        Box(
            modifier = Modifier
                .size(70.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(category.third)
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = category.second,
                contentDescription = category.first,
                modifier = Modifier.size(40.dp),
                tint = Color(0xFF2196F3)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = category.first,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun TutorialSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    "Lihat Tutorial",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.DarkGray
                )
                Text(
                    "Bikin surat hanya dalam 1 menit",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }

            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF00BCD4)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = androidx.compose.material.icons.Icons.Default.PlayArrow,
                    contentDescription = "Play",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Composable
fun BottomNavigationBar() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf(
        Pair("Beranda", androidx.compose.material.icons.Icons.Default.Home),
        Pair("File Saya", androidx.compose.material.icons.Icons.Default.Home),
        Pair("Akun", androidx.compose.material.icons.Icons.Default.Person),
        Pair("Pengaturan", androidx.compose.material.icons.Icons.Default.Settings)
    )

    NavigationBar(
        containerColor = Color.White,
        contentColor = Color(0xFF00BCD4),
        tonalElevation = 8.dp
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.second,
                        contentDescription = item.first,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = {
                    Text(
                        item.first,
                        fontSize = 12.sp
                    )
                },
                selected = selectedItem == index,
                onClick = { selectedItem = index },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF00BCD4),
                    selectedTextColor = Color(0xFF00BCD4),
                    indicatorColor = Color.White,
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray
                )
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BerandaScreenPreview() {
    BerandaScreen(navController = rememberNavController())
}