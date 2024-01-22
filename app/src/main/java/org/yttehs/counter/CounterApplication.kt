package org.yttehs.counter

import android.app.Application
import org.yttehs.counter.number.data.NumbersContainer
import org.yttehs.counter.number.data.NumbersDataContainer

class CounterApplication : Application() {
    lateinit var container: NumbersContainer

    override fun onCreate() {
        super.onCreate()
        container = NumbersDataContainer(this)
    }
}