package org.yttehs.counter.about.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.yttehs.counter.R

@Composable
fun ItemsList(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        BasicInfoItem(
            modifier = Modifier
                .padding(
                    top = 8.dp,
                    bottom = 8.dp
                )
                .fillMaxWidth()
                .wrapContentHeight()
                .align(Alignment.CenterHorizontally)
                .background(
                    color = MaterialTheme.colorScheme.inverseOnSurface,
                    shape = RoundedCornerShape(16.dp)
                ),
            icon = Icons.Filled.Info,
            text = "v ${stringResource(id = R.string.version_name)}"
        )
    }
}

@Preview(name = "ItemsList")
@Composable
fun ItemsListPreview() {
    ItemsList(
        modifier = Modifier
            .fillMaxSize()
    )
}