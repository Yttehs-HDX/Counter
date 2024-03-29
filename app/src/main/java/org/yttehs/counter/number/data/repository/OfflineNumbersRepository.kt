package org.yttehs.counter.number.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import org.yttehs.counter.number.data.dao.NumberDao
import org.yttehs.counter.number.data.model.NumberEntity

class OfflineNumbersRepository(private val numberDao: NumberDao) : NumbersRepository {
    override suspend fun insertNumber(numberEntity: NumberEntity) = numberDao.insert(numberEntity)

    override suspend fun updateNumber(numberEntity: NumberEntity) = numberDao.update(numberEntity)

    override suspend fun insertOrUpdateNumber(numberEntity: NumberEntity) =
        if (getNumberStream().first() == null) {
            insertNumber(numberEntity)
        } else {
            updateNumber(numberEntity)
        }

    override fun getNumberStream(): Flow<NumberEntity?> = numberDao.getNumber()
}