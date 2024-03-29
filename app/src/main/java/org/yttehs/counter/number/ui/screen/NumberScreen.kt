package org.yttehs.counter.number.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.yttehs.counter.number.ui.NumberUiState
import org.yttehs.counter.number.ui.component.NumberButton
import org.yttehs.counter.ui.component.basic.WaveCircle

@Composable
fun NumberScreen(
    numberUiState: NumberUiState,
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit
) {
    Box(
        modifier = modifier
    ) {
        WaveCircle(
            edgeNumber = 12,
            radian = 15f,
            color = MaterialTheme.colorScheme.inversePrimary,
            modifier = Modifier
                .width(256.dp)
                .align(Alignment.Center),
            strokeWidth = 20f
        )
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

@Preview(name = "NumberScreen")
@Composable
fun NumberScreenPreview() {
    NumberScreen(
        numberUiState = NumberUiState(0L, 114514L),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = MaterialTheme.shapes.large
            ),
        onButtonClick = { }
    )
}