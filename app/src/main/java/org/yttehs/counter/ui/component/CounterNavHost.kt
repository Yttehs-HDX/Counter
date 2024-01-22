package org.yttehs.counter.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.yttehs.counter.CounterDestination
import org.yttehs.counter.number.ui.NumberContent

@Composable
fun CounterNavHost(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = CounterDestination.NumberScreen.route) {
            NumberContent(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize()
                    .background(
                        color = MaterialTheme.colorScheme.inverseOnSurface,
                        shape = MaterialTheme.shapes.large
                    )
            )
        }
    }
}