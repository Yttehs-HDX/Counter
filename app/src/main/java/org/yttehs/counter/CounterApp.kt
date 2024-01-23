package org.yttehs.counter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
            SystemBar(
                statusBarColor = MaterialTheme.colorScheme.background,
                navigationBarColor = MaterialTheme.colorScheme.inverseOnSurface
            )
            CounterContent(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .fillMaxSize()
            )
        }
    }
}

@Composable
fun SystemBar(
    statusBarColor: Color,
    navigationBarColor: Color
) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.apply {
            setStatusBarColor(color = statusBarColor)
            setNavigationBarColor(color = navigationBarColor)
        }
    }
}