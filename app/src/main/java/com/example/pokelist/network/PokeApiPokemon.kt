package com.example.pokelist.network

import kotlinx.serialization.Serializable

/**
 * Response pokemon from pokeApi
 */
@Serializable
data class PokeApiPokemon(
    val id: Int,
    val name: String,
    val sprites: Sprites
)