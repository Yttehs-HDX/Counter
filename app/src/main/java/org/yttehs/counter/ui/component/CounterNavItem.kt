package org.yttehs.counter.ui.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CounterNavItem(
    modifier: Modifier = Modifier,
    text: String,
    unselectedColor: Color = MaterialTheme.colorScheme.inverseOnSurface,
    selectedColor: Color = MaterialTheme.colorScheme.secondaryContainer,
    unselectedIcon: ImageVector,
    selectedIcon: ImageVector,
    isSelected: Boolean = false,
    onSelect: () -> Unit,
) {
    Box(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 500,
                        easing = LinearOutSlowInEasing
                    )
                )
        ) {
            val containerColor by animateColorAsState(
                targetValue = if (isSelected) selectedColor
                else unselectedColor,
                animationSpec = tween(
                    durationMillis = 500,
                    easing = LinearOutSlowInEasing
                ),
                label = "ButtonColorAnimation"
            )
            Button(
                onClick = onSelect,
                colors = ButtonDefaults.buttonColors(
                    containerColor = containerColor
                ),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Image(
                    imageVector = if (isSelected) {
                        selectedIcon
                    } else {
                        unselectedIcon
                    },
                    contentDescription = text,
                    colorFilter = ColorFilter
                        .tint(
                            color = MaterialTheme.colorScheme.onSurface
                        ),
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )
            }
            if (isSelected) {
                Text(
                    text = text,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

@Preview(name = "CounterNavItem", showBackground = true)
@Composable
fun CounterNavItemPreView() {
    CounterNavItem(
        text = "Home",
        unselectedIcon = Icons.Outlined.Home,
        selectedIcon = Icons.Default.Home,
        isSelected = true,
        onSelect = { }
    )
}