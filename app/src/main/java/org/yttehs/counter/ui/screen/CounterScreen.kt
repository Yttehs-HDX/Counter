package org.yttehs.counter.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import org.yttehs.counter.ui.component.CounterBottomNavigation
import org.yttehs.counter.ui.component.CounterNavHost
import org.yttehs.counter.ui.component.CounterTopBar

@Composable
fun CounterScreen(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier,
    navBuilder: NavGraphBuilder.() -> Unit,
    navItems: @Composable RowScope.() -> Unit
) {
    Column(
        modifier = modifier
    ) {
        CounterTopBar()
        CounterNavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = Modifier.weight(1f)
        ) {
            navBuilder()
        }
        CounterBottomNavigation(
            modifier = Modifier
                .height(96.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .background(
                    color = MaterialTheme.colorScheme.inverseOnSurface
                )
        ) {
            navItems()
        }
    }
}
