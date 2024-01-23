package org.yttehs.counter.about.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.yttehs.counter.R

@Composable
fun IconItem(
    modifier: Modifier = Modifier,
    iconRoundedCorner: Dp = 90.dp
) {
    Box(
        modifier = modifier
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(16.dp)
                .clip(
                    shape = RoundedCornerShape(iconRoundedCorner)
                ),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "ic_launcher_background"
        )
        Image(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Center),
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "ic_launcher_foreground"
        )
    }
}

@Preview(name = "IconItem")
@Composable
fun IconItemPreview() {
    IconItem(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(
                color = MaterialTheme.colorScheme.inverseOnSurface,
                shape = RoundedCornerShape(8.dp)
            )
    )
}