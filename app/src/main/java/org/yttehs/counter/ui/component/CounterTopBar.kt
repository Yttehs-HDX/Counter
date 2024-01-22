package org.yttehs.counter.ui.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.statusBarsHeight

@Composable
fun CounterTopBar() {
    Spacer(
        modifier = Modifier
            .statusBarsHeight()
            .fillMaxWidth()
    )
}

@Preview(name = "CounterTopBar")
@Composable
fun CounterTopBarPreview() {
    CounterTopBar()
}