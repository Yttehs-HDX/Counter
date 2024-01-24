package org.yttehs.counter.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import org.yttehs.counter.CounterDestination
import org.yttehs.counter.ui.screen.CounterBottomBarScreen

@Composable
fun CounterBottomBarContent(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier,
    onSelect: (CounterDestination) -> Unit
) {
    CounterBottomBarScreen(
        startDestination = startDestination,
        modifier = modifier
    ) { destination ->
        navController.navigateSingleTopTo(destination.route)
        onSelect(destination)
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
