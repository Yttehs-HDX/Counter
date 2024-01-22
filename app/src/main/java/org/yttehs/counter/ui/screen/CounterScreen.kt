package org.yttehs.counter.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import org.yttehs.counter.ui.component.CounterBottomBar
import org.yttehs.counter.ui.component.CounterNavHost
import org.yttehs.counter.ui.component.CounterTopBar

@Composable
fun CounterScreen(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        CounterTopBar()
        CounterNavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = Modifier.fillMaxSize()
        )
        CounterBottomBar()
    }
}
