package org.yttehs.counter.about.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BasicInfoItem(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    text: String
) {
    Row(
        modifier = modifier
    ) {
        Spacer(
            modifier = Modifier.width(8.dp)
        )
        Image(
            imageVector= icon,
            contentDescription = text,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.inversePrimary),
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterVertically)
        )
        Spacer(
            modifier = Modifier.width(8.dp)
        )
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(16.dp)
                .weight(1f)
                .align(Alignment.CenterVertically)
        )
        Spacer(
            modifier = Modifier.width(8.dp)
        )
    }
}

@Preview(name = "BasicInfoItem")
@Composable
fun BasicInfoItemPreview() {
    BasicInfoItem(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .background(
                color = MaterialTheme.colorScheme.inverseOnSurface,
                shape = RoundedCornerShape(16.dp)
            ),
        icon = Icons.Filled.Info,
        text = "v114.514"
    )
}