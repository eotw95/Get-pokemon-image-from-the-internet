package com.example.pokelist.network

import kotlinx.serialization.Serializable

@Serializable
data class PokeApiPokemon(
    val id: Int,
    val name: String,
    val sprites: Sprites
)