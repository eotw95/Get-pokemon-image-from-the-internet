package com.example.pokelist.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://pokeapi.co/api/v2/"

private val retrofit = Retrofit
    .Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

/**
 * PokeApi client by using Retrofit
 */
// Todo: getPokeData()でconverterの生成ができていないらしい
//  java.lang.IllegalArgumentException: Unable to create converter for class com.example.pokelist.network.PokeApiPokemon
interface PokeApiService {
    @GET("pokemon/{name}/")
    suspend fun getPokeApiPokemon(@Path("name") name: String): Response<PokeApiPokemon>
}

object PokeApi {
    val retrofitService: PokeApiService by lazy {
        retrofit.create(PokeApiService::class.java)
    }
}