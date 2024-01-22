package org.yttehs.counter.number.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import org.yttehs.counter.AppViewModelProvider
import org.yttehs.counter.number.ui.screen.NumberScreen

@Composable
fun NumberContent(
    modifier: Modifier = Modifier
) {
    val numberUiViewModel: NumberViewModel = viewModel(factory = AppViewModelProvider.Factory)
    val numberUiState by numberUiViewModel.numberUiState.collectAsState()
    NumberScreen(
        numberUiState = numberUiState,
        modifier = modifier,
        onButtonClick = {
            numberUiViewModel.increaseNumber()
        }
    )
}