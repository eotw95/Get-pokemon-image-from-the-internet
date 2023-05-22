package com.example.pokelist.ui.theme.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    Text(text = pokeList)
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Text(text = "Getting data failed")
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
}