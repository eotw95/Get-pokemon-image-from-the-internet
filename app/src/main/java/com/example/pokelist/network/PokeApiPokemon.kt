package com.example.pokelist.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Response pokemon from pokeApi
 */
@Serializable
data class PokeApiPokemon(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("sprites") val sprites: Sprites
)