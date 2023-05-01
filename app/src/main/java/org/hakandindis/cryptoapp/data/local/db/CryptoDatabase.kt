package org.hakandindis.cryptoapp.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.hakandindis.cryptoapp.data.local.dao.CoinDao
import org.hakandindis.cryptoapp.data.local.model.coin.CoinEntity


@Database(entities = [CoinEntity::class], version = 1)
abstract class CryptoDatabase : RoomDatabase() {
    abstract fun coinDao(): CoinDao

    companion object {

        private const val DATABASE_NAME = "lancer_database"

        @Volatile
        private var INSTANCE: CryptoDatabase? = null

        fun getDatabase(context: Context): CryptoDatabase {
            return INSTANCE ?: synchronized(this) {
                return Room.databaseBuilder(
                    context.applicationContext,
                    CryptoDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }
        }
    }
}