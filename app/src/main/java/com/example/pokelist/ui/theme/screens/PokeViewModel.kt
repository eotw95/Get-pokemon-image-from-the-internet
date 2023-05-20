package com.example.pokelist.ui.theme.screens

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
    var pokeUiState: PokeUiState by mutableStateOf(PokeUiState.Loading)
    private set

    init {
        getPokeList()
    }

    private fun getPokeList() {
        viewModelScope.launch {
            val list = PokeApi.retrofitService.getPokeInfo()
            pokeUiState = PokeUiState.Success(list)
        }
    }
}