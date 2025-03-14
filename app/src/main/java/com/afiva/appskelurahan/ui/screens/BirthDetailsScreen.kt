package com.afiva.appskelurahan.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.afiva.appskelurahan.ui.component.RadioOption

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthDetailsScreen()
        }
    }
}

@Composable
fun BirthDetailsScreen() {
    var fullName by remember { mutableStateOf("") }
    var dateOfBirth by remember { mutableStateOf("") }
    var timeOfBirth by remember { mutableStateOf("") }
    var babyMeasurements by remember { mutableStateOf("") }
    var genderOptions = listOf("Male", "Female")
    var selectedGender by remember { mutableStateOf(genderOptions[0]) }
    var birthTypeOptions = listOf("Normal", "C-Section")
    var selectedBirthType by remember { mutableStateOf(birthTypeOptions[0]) }
    var birthPlaceOptions = listOf("Rumah Sakit", "Puskesmas", "Polindes", "Rumah", "Lainnya")
    var selectedBirthPlace by remember { mutableStateOf(birthPlaceOptions[0]) }
    var customBirthPlace by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Birth Details",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = fullName,
            onValueChange = { fullName = it },
            label = { Text("Full Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        RadioOption("Select Gender", listOf())
        Spacer(modifier = Modifier.height(8.dp))
        DropdownMenuField(
            "Tempat Dilahirkan",
            birthPlaceOptions,
            selectedBirthPlace
        ) { selectedBirthPlace = it }
        if (selectedBirthPlace == "Lainnya") {
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = customBirthPlace,
                onValueChange = { customBirthPlace = it },
                label = { Text("Masukkan Tempat Kelahiran") },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = dateOfBirth,
            onValueChange = { dateOfBirth = it },
            label = { Text("Date of Birth") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = timeOfBirth,
            onValueChange = { timeOfBirth = it },
            label = { Text("Time of Birth") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        DropdownMenuField(
            "Select Birth Type",
            birthTypeOptions,
            selectedBirthType
        ) { selectedBirthType = it }
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = babyMeasurements,
            onValueChange = { babyMeasurements = it },
            label = { Text("Baby Measurements") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(
                onClick = { /* Handle save */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6A4EFF)),
                modifier = Modifier.weight(1f)
            ) {
                Text("Save", color = Color.White)
            }
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedButton(
                onClick = { /* Handle save details */ },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text("Save the details", color = Color(0xFF6A4EFF))
            }
        }
    }
}

@Composable
fun DropdownMenuField(
    label: String,
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = selectedOption,
            onValueChange = {},
            label = { Text(label) },
            readOnly = true,
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = { expanded = true }) {
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Dropdown")
                }
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    onClick = {
                        onOptionSelected(option)
                        expanded = false
                    },
                    text = {
                        Text(option)
                    },
                    modifier = TODO(),
                    leadingIcon = TODO(),
                    trailingIcon = TODO(),
                    enabled = TODO(),
                    colors = TODO(),
                    contentPadding = TODO()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBirthDetailsScreen() {
    BirthDetailsScreen()
}
