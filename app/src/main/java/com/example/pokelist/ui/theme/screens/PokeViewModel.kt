package com.example.pokelist.ui.theme.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokelist.network.PokeApi
import kotlinx.coroutines.launch

interface PokeUiState {
    data class Success(val pokeList: String): PokeUiState
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
    private fun getPokemonInfo() {
        Log.d(TAG, "getPokeList")
        viewModelScope.launch {
            pokeUiState = try {
                val pokeInfo = PokeApi.retrofitService.getPokeData("chikorita")
                PokeUiState.Success(pokeInfo)
            } catch (e: Exception) {
                Log.d(TAG, "$e")
                Log.e(TAG, "getPokeList failed")
                PokeUiState.Error
            }
        }
    }
}