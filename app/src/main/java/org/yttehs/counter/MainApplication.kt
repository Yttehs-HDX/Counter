package org.yttehs.counter

import android.app.Application
import org.yttehs.counter.data.NumbersContainer
import org.yttehs.counter.data.NumbersDataContainer

class MainApplication : Application() {
    lateinit var container: NumbersContainer

    override fun onCreate() {
        super.onCreate()
        container = NumbersDataContainer(this)
    }
}