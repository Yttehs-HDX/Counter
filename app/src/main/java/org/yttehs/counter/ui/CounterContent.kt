package org.yttehs.counter.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.yttehs.counter.CounterDestination
import org.yttehs.counter.number.ui.NumberContent
import org.yttehs.counter.ui.component.CounterNavItem
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
        modifier = modifier,
        navBuilder = {
            composable(route = CounterDestination.NumberScreen.route) {
                NumberContent(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            color = MaterialTheme.colorScheme.background,
                            shape = MaterialTheme.shapes.large
                        )
                )
            }
        },
        navItems = {
            var isNumberScreenChosen by remember { mutableStateOf(true) }
            CounterNavItem(
                text = "Home",
                uncheckedIcon = Icons.Outlined.Home,
                checkedIcon = Icons.Default.Home,
                isChecked = isNumberScreenChosen,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(
                        top = 8.dp,
                        bottom = 0.dp,
                        start = 8.dp,
                        end = 8.dp
                    ),
                onChecked = {
                    if (!isNumberScreenChosen) {
                        navController.navigateSingleTopTo(CounterDestination.NumberScreen.route)
                        isNumberScreenChosen = !isNumberScreenChosen
                    }
                }
            )
        }
    )
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