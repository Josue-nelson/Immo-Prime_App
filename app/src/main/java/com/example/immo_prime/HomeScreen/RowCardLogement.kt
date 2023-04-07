package com.example.immo_prime.HomeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.immo_prime.R

@Composable
fun RowCardLogement(items: List<Logement>){
    Column {
        Text(
            text = "Similar Homes You May Likes",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        LazyRow{
            items(items){
                CardLogement(logement = Logement("Appartement", 50000.0,"Rue des palmier Nkolmesseng-Yaounde\nA 100m de Cyntiche Lounge", painterResource(id = R.drawable.house3), 2, 2, 900.0))
                CardLogement(logement = Logement("Appartement", 50000.0,"Rue des palmier Nkolmesseng-Yaounde\nA 100m de Cyntiche Lounge", painterResource(id = R.drawable.house3), 2, 2, 900.0))
                CardLogement(logement = Logement("Appartement", 50000.0,"Rue des palmier Nkolmesseng-Yaounde\nA 100m de Cyntiche Lounge", painterResource(id = R.drawable.house3), 2, 2, 900.0))
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun RowCardLogementPreview(){
    RowCardLogement(items = listOf(
        Logement("Appartement", 50000.0,"Rue des palmier Nkolmesseng-Yaounde\nA 100m de Cyntiche Lounge", painterResource(id = R.drawable.house3), 2, 2, 900.0)
    ))
}