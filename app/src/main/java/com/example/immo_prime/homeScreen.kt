package com.example.immo_prime

import android.Manifest
import android.app.Activity
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.google.android.gms.maps.MapsInitializer


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
                    val context = LocalContext.current
                    val mapView = rememberMapViewWithLifecycle()
                    var isPermissionGranted by remember { mutableStateOf(false) }
                    val fusedLocationClient = remember { LocationServices.getFusedLocationProviderClient(context) }

                    if (!isPermissionGranted) {
                        /*Button(
                            onClick = {*/
                                requestPermission(
                                    Manifest.permission.ACCESS_FINE_LOCATION,
                                    LOCATION_PERMISSION_REQUEST_CODE
                                )
                            /*},
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .padding(16.dp)
                        ) {
                            Text(text = "Autoriser la géolocalisation")
                        }*/
                    }

                    AndroidView({ mapView }) { mapView ->
                        mapView.getMapAsync { googleMap ->
                            MapsInitializer.initialize(context)
                            googleMap.uiSettings.isMyLocationButtonEnabled = false
                            googleMap.uiSettings.isZoomControlsEnabled = true

                            if (ActivityCompat.checkSelfPermission(
                                    context,
                                    Manifest.permission.ACCESS_FINE_LOCATION
                                ) == PackageManager.PERMISSION_GRANTED
                            ) {
                                googleMap.isMyLocationEnabled = true
                                fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
                                    location?.let {
                                        val currentLatLng = LatLng(location.latitude, location.longitude)
                                        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 15f))
                                    }
                                }
                            } else {
                                // Demander la permission de localisation
                                ActivityCompat.requestPermissions(
                                    context as Activity,
                                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                                    LOCATION_PERMISSION_REQUEST_CODE
                                )
                            }
                        }
                    }
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

        //@Composable
        /*private fun rememberMapViewWithLifecycle(): MapView {
            val context = LocalContext.current
            val mapView = remember {
                MapView(context).apply {
                    id = R.id.map_view
                }
            }

            val lifecycleOwner = LocalLifecycleOwner.current
            DisposableEffect(lifecycleOwner) {
                val observer = object : DefaultLifecycleObserver {
                    override fun onResume(owner: LifecycleOwner) {
                        mapView.onResume()
                    }

                    override fun onPause(owner: LifecycleOwner) {
                        mapView.onPause()
                    }

                    override fun onDestroy(owner: LifecycleOwner) {
                        mapView.onDestroy()
                    }
                }
                lifecycleOwner.lifecycle.addObserver(observer)

                onDispose {
                    lifecycleOwner.lifecycle.removeObserver(observer)
                }
            }

            return mapView
        }*/

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
@Composable
private fun rememberMapViewWithLifecycle() : MapView {
    val context = LocalContext.current
    val mapView = remember {
        MapView(context).apply {
            id = R.id.map_view
        }
    }

    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner) {
        val observer = object : DefaultLifecycleObserver {
            override fun onResume(owner: LifecycleOwner) {
                mapView.onResume()
            }

            override fun onPause(owner: LifecycleOwner) {
                mapView.onPause()
            }

            override fun onDestroy(owner: LifecycleOwner) {
                mapView.onDestroy()
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    return mapView
}


@Composable
private fun requestPermission(permission: String, requestCode: Int) {
    LocalContext.current.startActivity(
        Intent(
            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
            Uri.parse("package:${LocalContext.current.packageName}")
        )
    )
}

private const val LOCATION_PERMISSION_REQUEST_CODE = 123