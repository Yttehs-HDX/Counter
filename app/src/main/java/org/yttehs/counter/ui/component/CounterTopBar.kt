package org.yttehs.counter.ui.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CounterTopBar(
    modifier: Modifier = Modifier
) {
    Spacer(
        modifier = modifier
    )
}

@Preview(name = "CounterTopBar")
@Composable
fun CounterTopBarPreview() {
    CounterTopBar(
        modifier = Modifier
            .systemBarsPadding()
            .fillMaxWidth()
    )
}