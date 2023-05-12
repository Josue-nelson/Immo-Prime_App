package com.example.immo_prime.Utility

import androidx.compose.ui.graphics.painter.Painter

data class Logement(
    val id: Int = 0,
    val type: String = "",
    val price: Double = 0.0,
    val description: String = "",
    val Picture: Painter,
    val nbreDouche: Int = 0,
    val nbreChambre: Int = 0,
    val superficie: Double = 0.0
)