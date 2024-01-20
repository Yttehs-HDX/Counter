package org.yttehs.counter.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.yttehs.counter.data.database.NumberDatabase


@Entity(tableName = "numbers")
data class NumberEntity(
    @PrimaryKey
    val id: Long = 0L,

    val number: Long
)