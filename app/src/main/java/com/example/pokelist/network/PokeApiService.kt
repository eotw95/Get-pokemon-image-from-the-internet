package com.example.pokelist.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://pokeapi.co/api/v2/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .client(OkHttpClient())
    .addConverterFactory(
        MoshiConverterFactory.create(
            Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        )
    )
    .build()

/**
 * PokeApi client by using Retrofit
 */
interface PokeApiService {
//    @GET("pokemon/{name}/")
//    suspend fun getPokeApiPokemon(@Path("name") name: String): Response<PokeApiPokemon>

    @GET("pokemon/")
    suspend fun getPokeApiPokemon(): Response<PokeApiPokemon>
}

object PokeApi {
    val retrofitService: PokeApiService by lazy {
        retrofit.create(PokeApiService::class.java)
    }
}