package com.example.immo_prime

import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng
import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.appcompat.app.AlertDialog
import com.google.android.gms.common.api.GoogleApi
import com.google.android.gms.maps.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    companion object{
        private  const val LOCATION_PERMISSION_REQUEST_CODE =123
    }

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    fun setupMap() {
        val mapView = findViewById<MapView>(R.id.mapView)
        mapView.getMapAsync { mMap ->
            if (ActivityCompat.checkSelfPermission(
                    this, Manifest.permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                mMap.isMyLocationEnabled = true
                fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                    location?.let {
                        val currentLatLng = LatLng(it.latitude, it.longitude)
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 15f))
                    }
                }
            }
        }

    }

    override fun onMapReady(googleMap: GoogleMap) {
        setupMap()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission Granted
                setupMap()
            } else {
                showPermissionDeniedAlert {
                    finish()
                }
            }
        }
    }

    private fun showPermissionDeniedAlert(onDismiss: () -> Unit) {
        AlertDialog.Builder(this)
            .setMessage("Location permission is needed to access this feature. Please allow location permission in app settings.")
            .setPositiveButton("App settings") { _, _ ->
                startAppSettings()
            }
            .setNegativeButton("Exit") { _, _ ->
                onDismiss()
            }
            .show()
    }

    private fun startAppSettings() {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        val uri = Uri.fromParts("package", packageName, null)
        intent.data = uri
        startActivity(intent)
    }
}

