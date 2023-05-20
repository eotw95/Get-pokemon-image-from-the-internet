package com.example.pokelist.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pokelist.ui.theme.screens.HomeScreen
import com.example.pokelist.ui.theme.screens.PokeViewModel

@Composable
fun PokeListApp(modifier: Modifier = Modifier) {
    val pokeViewModel = PokeViewModel()
    HomeScreen(pokeUiState = pokeViewModel.pokeUiState)
}