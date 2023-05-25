package com.example.pokelist.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Todo: APIのデータ構造に合わせたdata classの用意
@Serializable
data class Pokemon(
    val abilities: List<PokemonAbility>?,
    @SerialName("base_experience") val baseExperience: Int?,
    val forms: List<PokemonForm>?,
    @SerialName("game_indices") val gameIndices: List<VersionGameIndex>?,
    val height: Int?,
    @SerialName("held_items") val heldItems: List<PokemonHeldItem>?,
    val id: Int?,
    @SerialName("is_default") val isDefault: Boolean?,
    @SerialName("location_area_encounters") val locationAreaEncounters: String?,
    val moves: List<PokemonMove>?,
    val name: String,
    val order: Int?,
    @SerialName("past_types") val pastTypes: List<PastType>?,
    val species: Species?,
    val sprites: PokemonSprites?,
    val stats: List<PokemonStat>?,
    val types: List<PokemonType>?,
    val weight: Int?,
)

// data classでデータの定義
@Serializable
data class PokemonAbility(
    val ability: Ability?,
    val slot: Int?,
    @SerialName("is_hidden")val isHidden: Boolean?
)