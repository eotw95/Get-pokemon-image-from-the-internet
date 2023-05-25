package com.example.pokelist.network

import kotlinx.serialization.Serializable

@Serializable
data class PokeDex(
    val id: Int = 0,
    val name: String = ""
)
