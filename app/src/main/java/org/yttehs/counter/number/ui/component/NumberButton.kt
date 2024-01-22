package org.yttehs.counter.number.ui.component

import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.yttehs.counter.NumberUiState

@Composable
fun NumberButton(numberUiState: NumberUiState, modifier: Modifier = Modifier, onButtonClick: () -> Unit) {
    Button(
        modifier = modifier,
        onClick = onButtonClick
    ) {
        Text(
            text = numberUiState.number.toString(),
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Preview(name = "Default Preview")
@Composable
fun DefaultPreview() {
    NumberButton(numberUiState = NumberUiState(0, 114514)) { }
}