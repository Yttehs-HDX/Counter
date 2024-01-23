package org.yttehs.counter.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CounterBottomNavigation(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
    ) {
        content()
    }
}

@Preview(name = "CounterBottomBar")
@Composable
fun CounterBottomBarPreview() {
    CounterBottomNavigation(
        modifier = Modifier
            .height(80.dp)
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .background(
                color = MaterialTheme.colorScheme.inverseOnSurface
            )
    ) {
        CounterNavItem(
            text = "Home",
            uncheckedIcon = Icons.Outlined.Home,
            checkedIcon = Icons.Default.Home,
            isChecked = true,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(16.dp),
            onChecked = { }
        )
    }
}