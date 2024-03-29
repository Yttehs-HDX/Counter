package org.yttehs.counter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.systemGestureExclusion
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import org.yttehs.counter.ui.CounterBottomBarContent
import org.yttehs.counter.ui.CounterContent
import org.yttehs.counter.ui.component.CounterTopBar
import org.yttehs.counter.ui.theme.CounterTheme

@Composable
fun CounterApp() {
    CounterTheme {
        SystemBar(
            statusBarColor = MaterialTheme.colorScheme.background,
            navigationColor = MaterialTheme.colorScheme.inverseOnSurface
        )
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()
            var selectedDestination by remember { mutableStateOf(CounterDestination.NumberContent.route) }
            Scaffold(
                topBar = {
                    CounterTopBar(
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                },
                bottomBar = {
                    CounterBottomBarContent(
                        navController = navController,
                        startDestination = selectedDestination,
                        modifier = Modifier
                            .wrapContentHeight()
                            .systemBarsPadding()
                            .systemGestureExclusion()
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                            .background(
                                color = MaterialTheme.colorScheme.inverseOnSurface
                            )
                    ) { destination ->
                        selectedDestination = destination.route
                    }
                }
            ) { innerPadding ->
                CounterContent(
                    navController = navController,
                    startDestination = selectedDestination,
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .padding(innerPadding)
                        .fillMaxSize()
                )
            }
        }
    }
}

@Suppress("DEPRECATION")
@Composable
fun SystemBar(
    statusBarColor: Color,
    navigationColor: Color
) {
    val systemUiController = rememberSystemUiController()
    LaunchedEffect(Unit) {
        systemUiController.apply {
            setStatusBarColor(statusBarColor)
            setNavigationBarColor(navigationColor)
        }
    }
}
