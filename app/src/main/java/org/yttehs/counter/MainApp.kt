package org.yttehs.counter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.insets.statusBarsHeight
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import org.yttehs.counter.ui.NumberButtonView
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
            ProvideWindowInsets {
                val systemUiController = rememberSystemUiController()
                val colorScheme = MaterialTheme.colorScheme
                SideEffect {
                    systemUiController.apply {
                        setSystemBarsColor(color = colorScheme.background)
                    }
                }
                ScreenProvider()
            }
        }
    }
}

@Composable
fun ScreenProvider() {
    MainScreen()
}

@Composable
fun MainScreen(viewModel: MainViewModel = viewModel(factory = AppViewModelProvider.Factory)) {
    Column(
        Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize(),
    ) {
        MainTopBar()
        MainContent(viewModel = viewModel)
        MainBottomNavigation()
    }
}

@Composable
fun MainTopBar() {
    Spacer(
        modifier = Modifier
            .statusBarsHeight()
            .fillMaxWidth()
    )
}

@Composable
fun MainContent(viewModel: MainViewModel) {
    val numberUiState by viewModel.numberUiState.collectAsState()
    NumberButtonView(numberUiState = numberUiState) {
        viewModel.increaseNumber()
    }
}

@Composable
fun MainBottomNavigation() {
    Spacer(
        modifier = Modifier
            .navigationBarsHeight()
            .fillMaxWidth()
    )
}
