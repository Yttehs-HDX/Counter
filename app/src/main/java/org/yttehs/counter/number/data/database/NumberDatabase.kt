package org.yttehs.counter.number.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.yttehs.counter.number.data.dao.NumberDao
import org.yttehs.counter.number.data.model.NumberEntity

@Database(entities = [NumberEntity::class], version = 1, exportSchema = false)
abstract class NumberDatabase : RoomDatabase() {
    abstract fun numberDao(): NumberDao

    companion object {
        @Volatile
        private lateinit var Instance: NumberDatabase

        fun getDatabase(context: Context): NumberDatabase = if (Companion::Instance.isInitialized) Instance
        else synchronized(this) {
            Instance = Room.databaseBuilder(
                context,
                NumberDatabase::class.java,
                "number_database"
            ).build()
            Instance
        }
    }
}