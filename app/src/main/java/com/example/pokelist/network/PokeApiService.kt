package com.example.pokelist.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "https://pokeapi.co/api/v2/pokemon/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory(MediaType.get("application:json")))
    .baseUrl(BASE_URL)
    .build()

interface PokeApiService {
    // todo:APIのendpoint確認
    @GET("id")
    suspend fun getPokeInfo(): String
}

object PokeApi {
    val retrofitService: PokeApiService by lazy {
        retrofit.create(PokeApiService::class.java)
    }
}