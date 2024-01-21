package org.yttehs.counter.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.yttehs.counter.NumberUiState

@Composable
fun NumberButtonView(numberUiState: NumberUiState, onButtonClick: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.inverseOnSurface,
                shape = MaterialTheme.shapes.large
            )
    ) {
        Button(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.Center)
                .wrapContentSize(),
            onClick = onButtonClick
        ) {
            Text(
                text = numberUiState.number.toString(),
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Preview(name = "Default Preview")
@Composable
fun DefaultPreview() {
    NumberButtonView(numberUiState = NumberUiState(0, 114514)) { }
}