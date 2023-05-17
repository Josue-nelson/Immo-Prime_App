package com.uistack.onboarding

import androidx.compose.ui.graphics.Color
import com.example.immo_prime.ui.theme.DarkBlueImo

data class OnBoardingData(
    val image: Int, val title: String,
    val desc: String,
    val backgroundColor:Color,
    val mainColor:Color = DarkBlueImo
)