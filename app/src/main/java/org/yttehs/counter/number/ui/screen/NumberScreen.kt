package org.yttehs.counter.number.ui.screen

import androidx.compose.runtime.Composable
import org.yttehs.counter.NumberUiState
import org.yttehs.counter.number.ui.component.NumberButton

@Composable
fun NumberScreen(numberUiState: NumberUiState, onButtonClick: () -> Unit) {
    NumberButton(
        numberUiState = numberUiState,
        onButtonClick = onButtonClick
    )
}