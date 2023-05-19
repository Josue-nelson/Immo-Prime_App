package com.example.immo_prime

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.immo_prime.DetaillScreen.TransparentBottomNavigation
import com.example.immo_prime.HomeScreen.CardLogement
import com.example.immo_prime.ui.theme.DarkBlueImo
import kotlinx.coroutines.launch
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")



@Composable
fun AdminScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Admin Screen") },
                backgroundColor = Color.Black,
                contentColor = Color.White,
                navigationIcon = { Icon(Icons.Default.Menu, contentDescription = null) }
            )
        },
        bottomBar = { TransparentBottomNavigation() },
        modifier = Modifier.fillMaxSize(),
        backgroundColor = Color.LightGray
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Welcome, Admin!", fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Spacer(modifier = Modifier.height(16.dp))
            CardLogement()
        }
    }
}

@Composable
fun TransparentBottomNavigation() {
    BottomNavigation(
        backgroundColor = Color.Transparent,
        elevation = 0.dp,
        modifier = Modifier.height(56.dp)
    ) {
        // Add your bottom navigation items here
    }
}

@Composable
fun CardLogement() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = R.drawable.house1),
                contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "My Beautiful House", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = "123 Main Street, Anytown USA")
        }
    }
}
