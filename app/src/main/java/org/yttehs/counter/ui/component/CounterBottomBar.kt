package org.yttehs.counter.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CounterBottomBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = modifier
    ) {
        content()
    }
}

@Preview(name = "CounterBottomBar")
@Composable
fun CounterBottomBarPreview() {
    CounterBottomBar(
        modifier = Modifier
            .wrapContentHeight()
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .background(
                color = MaterialTheme.colorScheme.inverseOnSurface
            )
    ) {
        Spacer(
            modifier = Modifier
                .weight(1f)
        )
        CounterNavItem(
            text = "Home",
            unselectedIcon = Icons.Outlined.Home,
            selectedIcon = Icons.Default.Home,
            isSelected = true,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(8.dp),
            onSelect = { }
        )
        Spacer(
            modifier = Modifier
                .weight(1f)
        )
        CounterNavItem(
            text = "About",
            unselectedIcon = Icons.Outlined.Info,
            selectedIcon = Icons.Default.Info,
            isSelected = true,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(8.dp),
            onSelect = { }
        )
        Spacer(
            modifier = Modifier
                .weight(1f)
        )
    }
}