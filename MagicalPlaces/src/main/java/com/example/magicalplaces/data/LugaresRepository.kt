package com.example.magicalplaces.data

class LugaresRepository {
    suspend fun getLugares() = WebService.retrofit.getLugares()
}