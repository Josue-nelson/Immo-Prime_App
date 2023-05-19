package com.example.immo_prime.Maps

import android.location.Location
import com.example.immo_prime.Maps.clusters.ZoneClusterItem

data class MapState(
    val lastKnownLocation: Location?,
    val clusterItems: List<ZoneClusterItem>,
)
