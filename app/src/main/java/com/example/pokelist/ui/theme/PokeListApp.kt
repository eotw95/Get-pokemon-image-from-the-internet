package com.example.pokelist.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pokelist.ui.theme.screens.HomeScreen
import com.example.pokelist.ui.theme.screens.PokeViewModel

@Composable
fun PokeListApp(modifier: Modifier = Modifier) {
    HomeScreen()
}