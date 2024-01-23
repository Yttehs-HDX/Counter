package org.yttehs.counter

sealed interface CounterDestination {
    val route: String
    val description: String

    data object NumberScreen : CounterDestination {
        override val route = CounterApplication.Context.getString(R.string.number_screen_route)
        override val description = CounterApplication.Context.getString(R.string.number_screen_description)
    }

    data object AboutScreen : CounterDestination {
        override val route: String = CounterApplication.Context.getString(R.string.about_screen_route)
        override val description = CounterApplication.Context.getString(R.string.about_screen_description)
    }
}

