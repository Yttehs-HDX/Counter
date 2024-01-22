package org.yttehs.counter.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import org.yttehs.counter.CounterDestination
import org.yttehs.counter.ui.screen.CounterScreen

@Composable
fun CounterContent(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val startDestination = CounterDestination.NumberScreen.route
    CounterScreen(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    )
}
