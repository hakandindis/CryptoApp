package org.hakandindis.cryptoapp.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import org.hakandindis.cryptoapp.data.local.dao.CoinDao
import org.hakandindis.cryptoapp.data.local.model.coin.CoinEntity


@Database(entities = [CoinEntity::class], version = 1)
abstract class CryptoDatabase : RoomDatabase() {
    abstract fun coinDao(): CoinDao
}