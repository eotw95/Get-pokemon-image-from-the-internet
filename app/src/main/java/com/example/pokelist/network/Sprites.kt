package com.example.pokelist.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Sprites(
    @SerialName("back_default") val backDefault: String,
    @SerialName("front_default") val frontDefault: String
)
