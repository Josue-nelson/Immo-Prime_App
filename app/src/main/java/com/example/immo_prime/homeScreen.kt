package com.example.immo_prime

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.net.Uri
import android.provider.Settings
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import androidx.compose.ui.platform.ContextAmbient


@Composable
fun MysScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.weight(1f)
        ) {
            // Définir l'en-tête ici

        }

        // Box 3: Description with price
        Box(modifier = Modifier.weight(1f)) {
            // Définir la description et le prix ici
        }

        // Box 2: TabBar with map and localisation
        Box(modifier = Modifier.weight(1f)) {
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
                    // Ajouter le bouton de permission de géolocalisation
                    var isPermissionGranted by remember { mutableStateOf(false) }
                    val fusedLocationClient = remember { LocationServices.getFusedLocationProviderClient(ContextAmbient.current) }

                    if (!isPermissionGranted) {
                        Button(
                            onClick = {
                                requestPermission(
                                    Manifest.permission.ACCESS_FINE_LOCATION,
                                    LOCATION_PERMISSION_REQUEST_CODE
                                )
                            },
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .padding(16.dp)
                        ) {
                            Text(text = "Autoriser la géolocalisation")
                        }
                    }

                    // Ajouter la vue MapView
                    AndroidView(factory = { context ->
                        val mapView = MapView(context).apply {
                            onCreate(null)
                            getMapAsync { googleMap ->
                                if (isPermissionGranted) {
                                    googleMap.isMyLocationEnabled = true
                                    if (ActivityCompat.checkSelfPermission(
                                            this,
                                            Manifest.permission.ACCESS_FINE_LOCATION
                                        ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                                            this,
                                            Manifest.permission.ACCESS_COARSE_LOCATION
                                        ) != PackageManager.PERMISSION_GRANTED
                                    ) {
                                        // TODO: Consider calling
                                        //    ActivityCompat#requestPermissions
                                        // here to request the missing permissions, and then overriding
                                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                        //                                          int[] grantResults)
                                        // to handle the case where the user grants the permission. See the documentation
                                        // for ActivityCompat#requestPermissions for more details.
                                        return@getMapAsync
                                    }
                                    fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
                                        location?.let {
                                            val currentLatLng = LatLng(location.latitude, location.longitude)
                                            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 15f))
                                        }
                                    }
                                }
                            }
                        }
                        mapView
                    }, update = { mapView ->
                        mapView.onResume()
                    })
                }
                1 -> {
                    // Ajouter les informations ici
                    Text(
                        text = "Cette Maison  est situé à Douala plus précisement à Logbessou derrière iuc à 100m de la route",
                        modifier = Modifier.padding(50.dp)
                    )
                }
            }
        }

        // Box 4: Description with price
        Box(modifier = Modifier.weight(1f)) {
            // Définir la description ici
        }

        // Ajouter les boutons de navigation ici
        BottomNavigation {
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Home, contentDescription = null) },
                selected = true,
                onClick = {}
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Search, contentDescription = null) },
                selected = false,
                onClick = {}
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.ShoppingCart, contentDescription = null) },
                selected = false,
                onClick = {}
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Settings, contentDescription = null) },
                selected = false,
                onClick = {}
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.LocationOn, contentDescription = null) },
                selected = false,
                onClick = {}
            )
        }
    }
}

private fun requestPermission(permission: String, requestCode: Int) {
    ContextAmbient.current.startActivity(
        Intent(
            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
            Uri.parse("package:${ContextAmbient.current.packageName}")
        )
    )
}

private const val LOCATION_PERMISSION_REQUEST_CODE = 123