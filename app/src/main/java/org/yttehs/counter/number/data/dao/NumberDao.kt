package org.yttehs.counter.number.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.yttehs.counter.number.data.model.NumberEntity

@Dao
interface NumberDao {
    @Insert
    suspend fun insert(numberEntity: NumberEntity)

    @Update
    suspend fun update(numberEntity: NumberEntity)

    @Query("SELECT * FROM numbers LIMIT 1")
    fun getNumber(): Flow<NumberEntity?>
}