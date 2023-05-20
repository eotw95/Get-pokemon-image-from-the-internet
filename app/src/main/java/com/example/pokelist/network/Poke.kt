package com.example.pokelist.network

import kotlinx.serialization.Serializable

@Serializable
data class Poke(
    val id: String,
    val name: String
)
