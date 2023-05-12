package com.example.immo_prime

import android.Manifest
import android.content.pm.PackageManager
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.app.ActivityCompat
import com.google.android.gms.maps.MapView


// ...

@Composable
fun MysScreen() {
    // ...
    // Box 2: TabBar with map and localisation
    Box(modifier = Modifier.fillMaxSize()) {
        val tabs = listOf("MAP", "INFORMATIONS")
        var selectedTabIndex by remember { mutableStateOf(0) }
        TabRow(selectedTabIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index }
                )
            }
        }
        when (selectedTabIndex) {
            0 -> {
                // Check for location permission and request if needed
                checkLocationPermissionAndShowMap()
            }
            1 -> {
                // Show information
            }
        }
    }

    // ...
}

@Composable
fun checkLocationPermissionAndShowMap() {
    val context = LocalContext.current
    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        // Request permission
        requestPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    } else {
        // Show map
        AndroidView(factory = { context -> MapView(context).apply { id = R.id.mapView } }) { mapView ->
            // Implement map initialization and location updates here
        }
    }
}

@Composable
fun requestPermission(permission: String) {
    // Start settings activity to let user enable permission
}