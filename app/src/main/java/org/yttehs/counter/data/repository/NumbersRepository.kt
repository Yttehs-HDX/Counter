package org.yttehs.counter.data.repository

import kotlinx.coroutines.flow.Flow
import org.yttehs.counter.data.model.NumberEntity

interface NumbersRepository {
    suspend fun insertNumber(numberEntity: NumberEntity)

    suspend fun updateNumber(numberEntity: NumberEntity)

    suspend fun insertOrUpdateNumber(numberEntity: NumberEntity)

    fun getNumberStream(): Flow<NumberEntity?>
}