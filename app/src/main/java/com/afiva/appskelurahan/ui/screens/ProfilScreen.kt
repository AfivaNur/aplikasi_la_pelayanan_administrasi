package com.afiva.appskelurahan.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    Scaffold { innerPadding ->
        Column (modifier = Modifier.verticalScroll(rememberScrollState())){
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(Color(0xFFF5F5F5))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Header tetap (fixed)
                    Box(modifier = Modifier.padding(horizontal = 12.dp)) {
                        ProfileHeader()
                    }

                    // Konten yang bisa di-scroll
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                        ,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(16.dp))
                        BioDataSection()
                        Spacer(modifier = Modifier.height(16.dp))
                        AddressSection()
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                // Info button at top right
                IconButton(
                    onClick = { /* TODO */ },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Info",
                        tint = Color.Gray
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileHeader() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFB9B28A)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Profile Icon",
                modifier = Modifier.size(60.dp),
                tint = Color.DarkGray
            )

            Text(
                "[ Your Name ]",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp)
            )

            Text(
                "16********12 (NIK)",
                fontSize = 14.sp,
                color = Color.White
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    "Profil",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.End
                )
            }
        }
    }
}

@Composable
fun BioDataSection() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFF8F3D9)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("BIODATA", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))

            ProfileTextField(label = "Nomor KK", placeholder = "masukkan nomor KK")
            ProfileTextField(label = "NIK", placeholder = "masukkan nomor NIK")
            ProfileTextField(label = "Nama Lengkap KTP", placeholder = "masukkan nama lengkap KTP")
            ProfileDateField(
                label = "Tempat/Tanggal Lahir",
                placeholder = "pilih tempat dan tanggal lahir"
            )
            GenderSelection()
            ProfileDropdownField(label = "Agama", placeholder = "pilih agama")
            ProfileDropdownField(
                label = "Status Perkawinan",
                placeholder = "pilih status perkawinan"
            )
            ProfileDropdownField(label = "Pekerjaan", placeholder = "pilih pekerjaan")
            CitizenshipSelection()
        }
    }
}

@Composable
fun AddressSection() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFF8F3D9)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Alamat", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))

            ProfileTextField(
                label = "Provinsi",
                placeholder = "Sumatera Selatan",
                value = "Sumatera Selatan"
            )
            ProfileTextField(
                label = "Kota/Kabupaten",
                placeholder = "Banyuasin",
                value = "Banyuasin"
            )
            ProfileTextField(
                label = "Kecamatan",
                placeholder = "Talang Kelapa",
                value = "Talang Kelapa"
            )
            ProfileTextField(
                label = "Kelurahan",
                placeholder = "Talang Keramat",
                value = "Talang Keramat"
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(modifier = Modifier.weight(1f)) {
                    ProfileDropdownField(label = "RW", placeholder = "")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Box(modifier = Modifier.weight(1f)) {
                    ProfileDropdownField(label = "RT", placeholder = "")
                }
                Spacer(modifier = Modifier.width(8.dp))

            }

            ProfileTextField(label = "No. Telp", placeholder = "masukkan nomor telepon")


            ProfileMultilineTextField(label = "Alamat Lengkap", placeholder = "")

            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.BottomEnd
            ) {
                Button(
                    onClick = { /* Edit Action */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFB9B28A),
                        contentColor = Color.Black
                    ),
                    shape = RoundedCornerShape(8.dp),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 2.dp
                    )
                ) {
                    Text("Edit Biodata")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileTextField(label: String, placeholder: String, value: String = "") {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = label,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = Color.DarkGray,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        OutlinedTextField(
            value = value,
            onValueChange = {},
            placeholder = { Text(placeholder, color = Color.LightGray) },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(4.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.LightGray,
                focusedBorderColor = Color.Gray,
                containerColor = Color.White
            ),
            singleLine = true
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileMultilineTextField(label: String, placeholder: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = label,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = Color.DarkGray,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text(placeholder, color = Color.LightGray) },
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            shape = RoundedCornerShape(4.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.LightGray,
                focusedBorderColor = Color.Gray,
                containerColor = Color.White
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileDateField(label: String, placeholder: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = label,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = Color.DarkGray,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text(placeholder, color = Color.LightGray) },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(4.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.LightGray,
                focusedBorderColor = Color.Gray,
                containerColor = Color.White
            ),
            singleLine = true,
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Calendar",
                    tint = Color.Gray
                )
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileDropdownField(label: String, placeholder: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = label,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = Color.DarkGray,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text(placeholder, color = Color.LightGray) },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(4.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.LightGray,
                focusedBorderColor = Color.Gray,
                containerColor = Color.White
            ),
            singleLine = true,
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Dropdown",
                    tint = Color.Gray
                )
            },
            readOnly = true
        )
    }
}

@Composable
fun GenderSelection() {
    var selectedGender by remember { mutableStateOf("Laki-laki") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = "Jenis Kelamin",
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = Color.DarkGray,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .background(Color.White, RoundedCornerShape(4.dp))
                .border(1.dp, Color.LightGray, RoundedCornerShape(4.dp))
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                RadioButton(
                    selected = selectedGender == "Laki-laki",
                    onClick = { selectedGender = "Laki-laki" },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = MaterialTheme.colorScheme.primary
                    )
                )
                Text(text = "Laki-laki", fontSize = 14.sp)
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                RadioButton(
                    selected = selectedGender == "Perempuan",
                    onClick = { selectedGender = "Perempuan" },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = MaterialTheme.colorScheme.primary
                    )
                )
                Text(text = "Perempuan", fontSize = 14.sp)
            }
        }
    }
}

@Composable
fun CitizenshipSelection() {
    var selectedCitizenship by remember { mutableStateOf("WNI") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = "Kewarganegaraan",
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = Color.DarkGray,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .background(Color.White, RoundedCornerShape(4.dp))
                .border(1.dp, Color.LightGray, RoundedCornerShape(4.dp))
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                RadioButton(
                    selected = selectedCitizenship == "WNI",
                    onClick = { selectedCitizenship = "WNI" },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = MaterialTheme.colorScheme.primary
                    )
                )
                Text(text = "WNI", fontSize = 14.sp)
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                RadioButton(
                    selected = selectedCitizenship == "WNA",
                    onClick = { selectedCitizenship = "WNA" },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = MaterialTheme.colorScheme.primary
                    )
                )
                Text(text = "WNA", fontSize = 14.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialTheme {
        ProfileScreen()
    }
}