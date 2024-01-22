package org.yttehs.counter.number.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.yttehs.counter.NumberUiState
import org.yttehs.counter.number.ui.component.NumberButton

@Composable
fun NumberScreen(
    numberUiState: NumberUiState,
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit
) {
    Box(
        modifier = modifier
    ) {
        NumberButton(
            numberUiState = numberUiState,
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.Center)
                .wrapContentSize(),
            onButtonClick = onButtonClick
        )
    }
}