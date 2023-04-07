package com.example.immo_prime.ville

import retrofit2.http.GET

interface ServiceStrapiVille{
    @GET("villes")
    fun getVilles() : String
}