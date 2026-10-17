package com.example.questtugasuserinput_0267

import android.app.DatePickerDialog
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormDataDiri(modifier: Modifier = Modifier) {
    var namaDepan by remember { mutableStateOf("") }
    var namaBelakang by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tglLahir by remember { mutableStateOf("") }

    var expanded by remember { mutableStateOf(false) }
    val experienceOptions = listOf("Fresh Graduate", "1-2 Tahun", "> 3 Tahun")
    var selectedExperience by remember { mutableStateOf("") }

    var isAndroidChecked by remember { mutableStateOf(false) }
    var isUiUxChecked by remember { mutableStateOf(false) }
    var isWebChecked by remember { mutableStateOf(false) }

    var isSubmitted by remember { mutableStateOf(false) }

    var finalNamaLengkap by remember { mutableStateOf("") }
    var finalEmail by remember { mutableStateOf("") }
    var finalTglLahir by remember { mutableStateOf("") }
    var finalExperience by remember { mutableStateOf("") }
    var finalSkills by remember { mutableStateOf("") }

    val context = LocalContext.current
    val isFormValid = namaDepan.isNotEmpty() && namaBelakang.isNotEmpty() && email.isNotEmpty() && tglLahir.isNotEmpty() && selectedExperience.isNotEmpty()

    // Menggunakan Column utama dengan scroll agar seluruh halaman bisa digulir
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        // 1. Gambar Header
        Image(
            painter = painterResource(id = R.drawable.foto_komunita),
            contentDescription = "Header Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp)
        )

        // 2. Form Melayang (ElevatedCard)
        // Kita beri padding horizontal sedikit agar shadow-nya terlihat, lalu tarik ke atas dengan offset
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp) // Memberi ruang untuk shadow di kiri kanan
                .offset(y = (-30).dp), // Menarik Card ke atas agar menimpa gambar
            shape = RoundedCornerShape(24.dp), // Melengkung di semua sudut
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp) // Ini yang memunculkan shadow tipis
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.form_title),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.form_title_color)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(id = R.string.form_subtitle),
                    fontSize = 12.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = namaDepan,
                        onValueChange = { namaDepan = it },
                        label = { Text(stringResource(id = R.string.hint_first_name), fontSize = 12.sp) },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp),
                        singleLine = true
                    )
                    OutlinedTextField(
                        value = namaBelakang,
                        onValueChange = { namaBelakang = it },
                        label = { Text(stringResource(id = R.string.hint_last_name), fontSize = 12.sp) },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp),
                        singleLine = true
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text(stringResource(id = R.string.hint_email), fontSize = 12.sp) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = tglLahir,
                        onValueChange = { },
                        readOnly = true,
                        label = { Text(stringResource(id = R.string.hint_birth_date), fontSize = 12.sp) },
                        trailingIcon = {
                            IconButton(onClick = {
                                val calendar = Calendar.getInstance()
                                val datePicker = DatePickerDialog(
                                    context,
                                    { _, year, month, dayOfMonth -> tglLahir = "$dayOfMonth/${month + 1}/$year" },
                                    calendar.get(Calendar.YEAR),
                                    calendar.get(Calendar.MONTH),
                                    calendar.get(Calendar.DAY_OF_MONTH)
                                )
                                datePicker.show()
                            }) {
                                Icon(Icons.Default.DateRange, contentDescription = "Pilih Tanggal")
                            }
                        },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    )

                    Box(modifier = Modifier.weight(1f)) {
                        OutlinedTextField(
                            value = selectedExperience,
                            onValueChange = { },
                            readOnly = true,
                            label = { Text(stringResource(id = R.string.hint_experience), fontSize = 12.sp) },
                            trailingIcon = {
                                IconButton(onClick = { expanded = !expanded }) {
                                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Dropdown")
                                }
                            },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp)
                        )
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            experienceOptions.forEach { option ->
                                DropdownMenuItem(
                                    text = { Text(option) },
                                    onClick = {
                                        selectedExperience = option
                                        expanded = false
                                    }
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = stringResource(id = R.string.label_skills),
                    modifier = Modifier.align(Alignment.Start),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(checked = isAndroidChecked, onCheckedChange = { isAndroidChecked = it })
                        Text(stringResource(id = R.string.skill_android), fontSize = 14.sp)
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(checked = isUiUxChecked, onCheckedChange = { isUiUxChecked = it })
                        Text(stringResource(id = R.string.skill_uiux), fontSize = 14.sp)
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(checked = isWebChecked, onCheckedChange = { isWebChecked = it })
                        Text(stringResource(id = R.string.skill_web), fontSize = 14.sp)
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))

                // Tombol Proceed
                Button(
                    onClick = {
                        finalNamaLengkap = "$namaDepan $namaBelakang".trim()
                        finalEmail = email
                        finalTglLahir = tglLahir
                        finalExperience = selectedExperience

                        val skillList = mutableListOf<String>()
                        if (isAndroidChecked) skillList.add("Android")
                        if (isUiUxChecked) skillList.add("UI/UX")
                        if (isWebChecked) skillList.add("Web")
                        finalSkills = if (skillList.isEmpty()) "-" else skillList.joinToString(", ")

                        isSubmitted = true
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isFormValid) colorResource(id = R.color.purple_500) else colorResource(id = R.color.button_disabled_gray),
                        contentColor = if (isFormValid) Color.White else Color.Gray
                    ),
                    enabled = isFormValid
                ) {
                    Text(
                        text = stringResource(id = R.string.submit),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            }
        }


}