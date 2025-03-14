package com.afiva.appskelurahan.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuratKeteranganTidakMampu() {
    var name by remember { mutableStateOf("") }
    var dateOfBirth by remember { mutableStateOf("") }
    var placeOfBirth by remember { mutableStateOf("") }

    val primaryColor = Color(0xFF6750A4) // Purple color similar to the image

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = false,
                    onClick = { },
                    icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                    label = { Text("Home") }
                )
                NavigationBarItem(
                    selected = true,
                    onClick = { },
                    icon = { Icon(Icons.Outlined.Email, contentDescription = "Forms") },
                    label = { Text("Forms") }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { },
                    icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") },
                    label = { Text("Profile") }
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 20.dp)
        ) {
            // Status bar spacer
            Spacer(modifier = Modifier.height(40.dp))

            // Title
            Text(
                text = "Surat Keterangan Tidak Mampu",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            // Name Field
            OutlinedTextField(
                value = name,
                label = {
                    Text("Nama")
                },
                onValueChange = { name = it },
                placeholder = { Text("Enter name") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.LightGray
                ),
                shape = RoundedCornerShape(8.dp)
            )

            // Date of Birth Field
            OutlinedTextField(
                value = dateOfBirth,
                label = {
                    Text("Tanggal Lahir")
                },
                onValueChange = { dateOfBirth = it },
                placeholder = { Text("Tanggal Lahir") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.LightGray
                ),
                shape = RoundedCornerShape(8.dp)
            )

            // Place of Birth Field

            OutlinedTextField(
                value = placeOfBirth,
                label = {
                    Text("Jenis Kelamin")
                },
                onValueChange = { placeOfBirth = it },
                placeholder = { Text("Enter place") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.LightGray
                ),
                shape = RoundedCornerShape(8.dp)
            )

            // Place of Birth Field

            OutlinedTextField(
                value = placeOfBirth,
                label = {
                    Text("Jenis Kelamin")
                },
                onValueChange = { placeOfBirth = it },
                placeholder = { Text("Enter place") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.LightGray
                ),
                shape = RoundedCornerShape(8.dp)
            )

            // Place of Birth Field

            OutlinedTextField(
                value = placeOfBirth,
                label = {
                    Text("Jenis Kelamin")
                },
                onValueChange = { placeOfBirth = it },
                placeholder = { Text("Enter place") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.LightGray
                ),
                shape = RoundedCornerShape(8.dp)
            )

            // Spacer
            Spacer(modifier = Modifier.weight(1f))

            // Buttons Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = { /* Implement confirm logic */ },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Confirm",
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }

                TextButton(
                    onClick = { /* Implement edit logic */ },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Edit",
                        color = primaryColor
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Preview
@Composable
fun SuratKeteranganTidakMampuPreview(){
    SuratKeteranganTidakMampu()
}