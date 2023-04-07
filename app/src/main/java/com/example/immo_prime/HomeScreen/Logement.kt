package com.example.immo_prime.HomeScreen

import androidx.compose.ui.graphics.painter.Painter

data class Logement(
    val type: String,
    val price: Double,
    val description: String,
    val Picture: Painter,
    val nbreDouche: Int,
    val nbreChambre: Int,
    val superficie: Double
)