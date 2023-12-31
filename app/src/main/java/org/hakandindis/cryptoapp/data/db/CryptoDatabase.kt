package org.hakandindis.cryptoapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import org.hakandindis.cryptoapp.data.local.dao.CoinDao
import org.hakandindis.cryptoapp.data.local.entity.CoinEntity


@Database(entities = [CoinEntity::class], version = 1)
abstract class CryptoDatabase : RoomDatabase() {
    abstract fun coinDao(): CoinDao
}