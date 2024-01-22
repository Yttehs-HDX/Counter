package org.yttehs.counter

sealed interface CounterDestination {
    val route: String

    data object NumberScreen : CounterDestination {
        override val route = CounterApplication.Context.getString(R.string.number_screen)
    }
}

