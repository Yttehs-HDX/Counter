package org.yttehs.counter.ui.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.yttehs.counter.CounterDestination
import org.yttehs.counter.ui.component.CounterBottomBar
import org.yttehs.counter.ui.component.CounterNavItem

@Composable
fun CounterBottomBarScreen(
    startDestination: String,
    modifier: Modifier = Modifier,
    onSelect: (CounterDestination) -> Unit
) {
    CounterBottomBar(
        modifier = modifier
    ) {
        Spacer(
            modifier = Modifier
                .weight(1f)
        )
        for (destination in CounterDestination.AllDestinations) {
            CounterNavItem(
                text = destination.description,
                unselectedIcon = destination.uncheckedIcon,
                selectedIcon = destination.checkedIcon,
                isSelected = destination.route == startDestination,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(8.dp),
                onSelect = {
                    onSelect(destination)
                }
            )
            Spacer(
                modifier = Modifier
                    .weight(1f)
            )
        }
    }
}
