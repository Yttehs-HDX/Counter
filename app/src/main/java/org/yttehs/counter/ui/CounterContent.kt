package org.yttehs.counter.ui

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.yttehs.counter.CounterDestination

@Composable
fun CounterContent(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        enterTransition = {
            fadeIn(
                animationSpec = tween(1000)
            ) + slideIntoContainer(
                initialOffset = { fullSize -> fullSize / 4 },
                animationSpec = tween(500),
                towards = AnimatedContentTransitionScope.SlideDirection.Up
            )
        },
        modifier = modifier
    ) {
        for (destination in CounterDestination.AllDestinations) {
            composable(route = destination.route) {
                destination.Content(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            color = MaterialTheme.colorScheme.background
                        )
                )
            }
        }
    }
}
