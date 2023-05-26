package com.example.pokelist.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Todo: APIのデータ構造に合わせたdata classの用意は全部満たさなくてもいいらしい。使いたい項目のみ。
@Serializable
data class Pokemon(
    val id: Int?,
    val name: String,
    @SerialName("base_experience") val baseExperience: Int?,
    val height: Int?,
    @SerialName("is_default") val isDefault: Boolean?,
    val order: Int?,
    val weight: Int?,
    val abilities: List<PokemonAbility>?,
    val forms: List<PokemonForm>?,
    @SerialName("game_indices") val gameIndices: List<VersionGameIndex>?,
    @SerialName("held_items") val heldItems: List<PokemonHeldItem>?,
    @SerialName("location_area_encounters") val locationAreaEncounters: String?,
    val moves: List<PokemonMove>?,
    val species: Species?,
    val sprites: PokemonSprites?,
    val stats: List<PokemonStat>?,
    val types: List<PokemonType>?,
    @SerialName("past_types") val pastTypes: List<PokemonPastType>?
)

@Serializable
data class PokemonAbility(
    @SerialName("is_hidden")val isHidden: Boolean?,
    val slot: Int?,
    val ability: Ability?
)