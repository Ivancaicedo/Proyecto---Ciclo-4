package com.example.magicalplaces.models


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LugarItem(
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("imagen")
    val imagen: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("descripcionLarga")
    val descripcionLarga: String,
    @SerializedName("latitud")
    val latitud: String,
    @SerializedName("longitud")
    val longitud: String,
    @SerializedName("zoom")
    val zoom: String
):Serializable