package com.example.pokelist.ui.theme.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.pokelist.R
import com.example.pokelist.network.Pokemon

@Composable
fun HomeScreen(
    pokeViewModel: PokeViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    when(val pokeUiState = pokeViewModel.pokeUiState) {
        is PokeUiState.Success -> ResultScreen(pokeUiState.pokemonData, modifier)
        is PokeUiState.Error -> ErrorScreen(modifier)
        is PokeUiState.Loading -> LoadingScreen(modifier)
    }
}

@Composable
fun ResultScreen(pokemonData: Pokemon, modifier: Modifier = Modifier) {
    AsyncImage(
        model = ImageRequest.Builder(context = LocalContext.current)
            .data(pokemonData.imageSrc)
            .crossfade(true)
            .build(),
        contentDescription = stringResource(id = R.string.pokemon_image),
        contentScale = ContentScale.FillBounds,
    )
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Text(text = "Getting data failed")
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
}