package com.afiva.appskelurahan.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
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

@Composable
fun SuratPengantarForm() {
    var selectedRT by remember { mutableStateOf("") }
    val rtOptions = listOf("RT 01", "RT 02", "RT 03", "RT 04")

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text("FORM", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text("( Surat Pengantar RT )", fontSize = 16.sp, color = Color.Gray)

            Spacer(modifier = Modifier.height(16.dp))

            CardSection {
                Text("Pilih RT", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                DropdownMenuField(selectedRT, rtOptions) { selectedRT = it }
            }

            Spacer(modifier = Modifier.height(16.dp))

            SectionTitle("Kelengkapan RT (yang bertanda tangan*)")
            CardSection {
                FormTextField("Nama Ketua RT", "Masukkan nama ketua RT")
                FormTextField("Jabatan", "Masukkan jabatan")
            }

            Spacer(modifier = Modifier.height(16.dp))

            SectionTitle("Kelengkapan Pembuat")
            CardSection {
                FormTextField("Nama Lengkap KTP", "Masukkan nama lengkap KTP")
                FormTextField("Tempat/Tanggal Lahir", "Pilih tempat dan tanggal lahir")

                RadioOption("Jenis Kelamin", listOf("Laki-laki", "Perempuan"))
                
                ProfileDropdownField(label = "Agama", placeholder = "pilih agama")
                ProfileDropdownField(
                    label = "Status Perkawinan",
                    placeholder = "pilih status perkawinan"
                )

                RadioOption("Kewarganegaraan", listOf("WNI", "WNA"))

                FormTextField("KK/NIK KTP", "Masukkan nomor KK/NIK KTP")
                FormTextField("Alamat", "Masukkan alamat")
                FormTextField("Keterangan Tujuan", "Masukkan keterangan tujuan")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /* TODO */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
            ) {
                Text("Ajukan", color = Color.White, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

// ==== Komponen Reusable ====

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        color = Color.DarkGray
    )
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun CardSection(content: @Composable ColumnScope.() -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.elevatedCardElevation(2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            content()
        }
    }
}

@Composable
fun FormTextField(label: String, placeholder: String) {
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(text = label, fontWeight = FontWeight.Medium, fontSize = 14.sp, color = Color.DarkGray)
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            placeholder = { Text(placeholder, color = Color.LightGray) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(4.dp),
            singleLine = true
        )
    }
}

@Composable
fun DropdownMenuField(selectedOption: String, options: List<String>, onSelection: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    var selected by remember { mutableStateOf(selectedOption) }

    Box(modifier = Modifier.fillMaxWidth()) {
        OutlinedButton(
            onClick = { expanded = true },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black)

        ) {
            Text(if (selected.isEmpty()) "Pilih RT" else selected)
            Icon(Icons.Default.ArrowDropDown, contentDescription = "Dropdown Arrow")
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    onClick = {
                        selected = option
                        onSelection(option)
                        expanded = false
                    },
                    text = {Text(option)},
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
fun PreviewSuratPengantarForm() {
    SuratPengantarForm()
}
