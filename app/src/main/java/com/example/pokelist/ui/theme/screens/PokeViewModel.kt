package com.example.pokelist.ui.theme.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokelist.network.PokeApi
import com.example.pokelist.network.Pokemon
import kotlinx.coroutines.launch

interface PokeUiState {
    data class Success(val pokemonData: Pokemon): PokeUiState
    object Error: PokeUiState
    object Loading: PokeUiState
}

class PokeViewModel: ViewModel() {
    companion object {
        const val TAG = "PokeViewModel"
    }
    var pokeUiState: PokeUiState by mutableStateOf(PokeUiState.Loading)
    private set

    init {
        getPokemonInfo()
    }

    // デバイスの時刻を現在時刻と一致させないとSSLHandshakeException発生する
    // エミュレーターの時刻を自動設定にしても現在時刻と合わないので手動で設定
    private fun getPokemonInfo() {
        Log.d(TAG, "getPokeList")
        viewModelScope.launch {
            pokeUiState = try {
                val pokeData = PokeApi.retrofitService.getPokeData("chikorita")
                PokeUiState.Success(pokeData)
            } catch (e: Exception) {
                Log.d(TAG, "$e")
                Log.e(TAG, "getPokeList failed")
                PokeUiState.Error
            }
        }
    }
}