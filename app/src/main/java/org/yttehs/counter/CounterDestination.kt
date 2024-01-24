package org.yttehs.counter

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import org.yttehs.counter.about.AboutContent
import org.yttehs.counter.number.ui.NumberContent

sealed interface CounterDestination {
    val route: String
    val description: String
    val uncheckedIcon: ImageVector
    val checkedIcon: ImageVector

    @Composable
    fun Content(modifier: Modifier)

    companion object {
        val AllDestinations = listOf(
            NumberContent,
            AboutContent
        )
    }

    data object NumberContent : CounterDestination {
        override val route = CounterApplication.Context.getString(R.string.number_screen_route)
        override val description = CounterApplication.Context.getString(R.string.number_screen_description)
        override val uncheckedIcon = Icons.Outlined.Home
        override val checkedIcon = Icons.Default.Home

        @Composable
        override fun Content(modifier: Modifier) =
            NumberContent(
                modifier = modifier
            )
    }

    data object AboutContent : CounterDestination {
        override val route: String = CounterApplication.Context.getString(R.string.about_screen_route)
        override val description = CounterApplication.Context.getString(R.string.about_screen_description)
        override val uncheckedIcon = Icons.Outlined.Info
        override val checkedIcon = Icons.Default.Info

        @Composable
        override fun Content(modifier: Modifier) =
            AboutContent(
                modifier = Modifier
            )
    }
}
