package com.example.magicalplaces.data

import com.example.magicalplaces.models.Lugar
import retrofit2.http.GET

interface ApiService {
    @GET("/Ivancaicedo/Proyecto-Ciclo-4/lugares")
    suspend fun getLugares(): Lugar
}