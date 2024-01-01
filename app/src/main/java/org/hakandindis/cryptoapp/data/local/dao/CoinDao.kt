package org.hakandindis.cryptoapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import org.hakandindis.cryptoapp.data.local.entity.CoinEntity

@Dao
interface CoinDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoin(coinEntity: CoinEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateCoin(coinEntity: CoinEntity)

    @Delete
    suspend fun deleteCoin(coinEntity: CoinEntity)

    @Query("SELECT id, name, symbol, price FROM coins")
    suspend fun getAllCoins(): List<CoinEntity>?
}