package org.yttehs.counter.about

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.yttehs.counter.about.ui.screen.AboutScreen

@Composable
fun AboutContent(
    modifier: Modifier = Modifier
) {
    AboutScreen(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
    )
}