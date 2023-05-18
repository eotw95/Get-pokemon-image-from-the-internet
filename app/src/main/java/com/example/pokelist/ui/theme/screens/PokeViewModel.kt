package com.example.pokelist.ui.theme.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokelist.network.PokeApi
import kotlinx.coroutines.launch

class PokeViewModel: ViewModel() {
    fun getPokeList() {
        viewModelScope.launch {
            val list = PokeApi.retrofitService.getPokeInfo()
        }
    }
}