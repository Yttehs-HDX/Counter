package org.yttehs.counter.ui.component

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CounterNavItem(
    modifier: Modifier = Modifier,
    text: String,
    uncheckedColor: Color = MaterialTheme.colorScheme.inverseOnSurface,
    checkedColor: Color = MaterialTheme.colorScheme.inversePrimary,
    uncheckedIcon: ImageVector,
    checkedIcon: ImageVector,
    isChecked: Boolean = false,
    onChecked: () -> Unit,
) {
    Box(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Button(
                onClick = onChecked,
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isChecked) {
                        checkedColor
                    } else {
                        uncheckedColor
                    }
                ),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Image(
                    imageVector = if (isChecked) {
                        checkedIcon
                    } else {
                        uncheckedIcon
                    },
                    contentDescription = text,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )
            }
            if (isChecked) {
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
        uncheckedIcon = Icons.Outlined.Home,
        checkedIcon = Icons.Default.Home,
        isChecked = true,
        onChecked = { }
    )
}