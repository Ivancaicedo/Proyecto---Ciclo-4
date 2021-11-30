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
    val descripcionLarga: String
):Serializable