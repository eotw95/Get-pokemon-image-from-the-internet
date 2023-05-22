package com.example.pokelist.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pokelist.ui.theme.screens.HomeScreen
import com.example.pokelist.ui.theme.screens.PokeViewModel

@Composable
fun PokeListApp(modifier: Modifier = Modifier) {
    // Composable内でviewModelをインスタンス化する際は
    // lifecycle-viewmodel-composeライブラリのviewModel()を使用。シングルトン。
    // 普通にViewModel()でインスタンス化すると再Composeが連発し大量のインスタンスが生成されてしまう。
    val pokeViewModel: PokeViewModel = viewModel()
    HomeScreen(pokeUiState = pokeViewModel.pokeUiState)
}