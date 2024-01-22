package org.yttehs.counter.number.data

import android.content.Context
import org.yttehs.counter.number.data.database.NumberDatabase
import org.yttehs.counter.number.data.repository.NumbersRepository
import org.yttehs.counter.number.data.repository.OfflineNumbersRepository

interface NumbersContainer {
    val numbersRepository: NumbersRepository
}

class NumbersDataContainer(private val context: Context) : NumbersContainer {
    override val numbersRepository: NumbersRepository by lazy {
        OfflineNumbersRepository(NumberDatabase.getDatabase(context).numberDao())
    }
}