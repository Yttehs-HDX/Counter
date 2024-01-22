package org.yttehs.counter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import org.yttehs.counter.ui.CounterContent
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
                CounterContent(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .fillMaxSize()
                )
            }
        }
    }
}
