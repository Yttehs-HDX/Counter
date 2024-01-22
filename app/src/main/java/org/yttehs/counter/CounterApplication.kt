package org.yttehs.counter

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import org.yttehs.counter.number.data.NumbersContainer
import org.yttehs.counter.number.data.NumbersDataContainer

class CounterApplication : Application() {
    lateinit var numbersContainer: NumbersContainer

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var Context: Context
    }

    override fun onCreate() {
        super.onCreate()
        Context = applicationContext
        numbersContainer = NumbersDataContainer(this)
    }
}