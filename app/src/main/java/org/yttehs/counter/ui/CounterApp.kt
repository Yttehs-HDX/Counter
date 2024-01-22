package org.yttehs.counter.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.insets.statusBarsHeight
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import org.yttehs.counter.AppViewModelProvider
import org.yttehs.counter.CounterViewModel
import org.yttehs.counter.number.ui.screen.NumberScreen
import org.yttehs.counter.ui.theme.CounterTheme

@Composable
fun CounterApp() {
    CounterTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ProvideWindowInsets {
                val systemUiController = rememberSystemUiController()
                val color = MaterialTheme.colorScheme.background
                SideEffect {
                    systemUiController.setSystemBarsColor(color = color)
                }
                CounterScreen()
            }
        }
    }
}

@Composable
fun CounterScreen(viewModel: CounterViewModel = viewModel(factory = AppViewModelProvider.Factory)) {
    Column(
        Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize(),
    ) {
        TopBar()
        CounterContent(viewModel = viewModel)
        BottomBar()
    }
}

@Composable
fun TopBar() {
    Spacer(
        modifier = Modifier
            .statusBarsHeight()
            .fillMaxWidth()
    )
}

@Composable
fun CounterContent(viewModel: CounterViewModel) {
    val numberUiState by viewModel.numberUiState.collectAsState()
    NumberScreen(
        numberUiState = numberUiState,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.inverseOnSurface,
                shape = MaterialTheme.shapes.large
            ),
        onButtonClick = {
            viewModel.increaseNumber()
        }
    )
}

@Composable
fun BottomBar() {
    Spacer(
        modifier = Modifier
            .navigationBarsHeight()
            .fillMaxWidth()
    )
}
