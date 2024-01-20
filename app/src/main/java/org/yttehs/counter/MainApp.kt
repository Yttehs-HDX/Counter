package org.yttehs.counter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.yttehs.counter.ui.theme.CounterTheme

@Composable
fun MainApp() {
    CounterTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NumberScreen()
        }
    }
}

@Composable
fun NumberScreen(viewModel: MainViewModel = viewModel(factory = AppViewModelProvider.Factory)) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.inverseOnSurface,
                shape = MaterialTheme.shapes.large
            )
    ) {
        val numberUiState by viewModel.numberUiState.collectAsState()
        Button(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Center)
                .wrapContentSize(),
            onClick = {
                viewModel.increaseNumber()
            }
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
    NumberScreen()
}