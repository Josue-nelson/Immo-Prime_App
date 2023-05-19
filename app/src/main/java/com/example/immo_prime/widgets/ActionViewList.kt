package com.tiagodanin.example.jetpack.nucompose.ui.widgets
//package com.example.immo_prime.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.immo_prime.R



@Composable
fun ActionViewList() {
    val scrollState = rememberScrollState()
    LaunchedEffect(Unit) {
        scrollState.animateScrollTo(0)
    }

    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxSize()
            .padding(vertical = 10.dp)
            .horizontalScroll(scrollState)
    ) {
        Spacer(modifier = Modifier.width(14.dp))
        ActionViewButton(
            text = "Code Qr",
            ImageVector.vectorResource(id = R.drawable.building_30px)
        )


        ActionViewButton(
            text = "Client",
            ImageVector.vectorResource(id = R.drawable.search_client_24px)
        )
        ActionViewButton(
            text = "Revenus",
            ImageVector.vectorResource(id = R.drawable.ic_cash)
        )

        ActionViewButton(
            text = "Like",
            ImageVector.vectorResource(id = R.drawable.ic_heart_outline)
        )
        ActionViewButton(
            text = "Proprietaire",
            ImageVector.vectorResource(id = R.drawable.police_30px)
        )
        ActionViewButton(
            text = "Transferir Internac.",
            ImageVector.vectorResource(id = R.drawable.ic_web)
        )
        ActionViewButton(
            text = "Encontrar atalhos",
            ImageVector.vectorResource(id = R.drawable.ic_help_circle_outline)
        )
        Spacer(modifier = Modifier.width(14.dp))
    }
}