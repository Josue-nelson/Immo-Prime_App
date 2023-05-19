package com.example.immo_prime.ville

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Composable
fun ListVille(){
    // Utilisation de Retrofit pour récupérer les données de l'API Strapi
    val retrofit = Retrofit.Builder()
        .baseUrl("http://localhost:1337/api/villes/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    println(retrofit.toString())
}

@Preview
@Composable
fun ListVillePreview(){
    ListVille()
}