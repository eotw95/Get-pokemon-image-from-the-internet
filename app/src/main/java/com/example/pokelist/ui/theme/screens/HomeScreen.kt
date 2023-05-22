package com.example.pokelist.ui.theme.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(
    pokeUiState: PokeUiState,
    modifier: Modifier = Modifier
) {
    when(pokeUiState) {
        is PokeUiState.Success -> ResultScreen(pokeUiState.pokeList, modifier)
        is PokeUiState.Error -> ErrorScreen(modifier)
        is PokeUiState.Loading -> LoadingScreen(modifier)
    }
}

@Composable
fun ResultScreen(pokeList: String, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(text = pokeList)
    }
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Text(text = "Getting data failed")
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
}