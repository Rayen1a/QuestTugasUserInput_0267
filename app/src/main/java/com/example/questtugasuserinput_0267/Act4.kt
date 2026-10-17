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


}