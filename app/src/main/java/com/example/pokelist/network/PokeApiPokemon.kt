package com.example.pokelist.network

import com.squareup.moshi.Json

/**
 * Response pokemon from pokeApi
 */
data class PokeApiPokemon(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "sprites") val sprites: Sprites
) {
    data class Sprites(
        @Json(name = "back_default") val backDefault: String,
        @Json(name = "front_default") val frontDefault: String
    )
}