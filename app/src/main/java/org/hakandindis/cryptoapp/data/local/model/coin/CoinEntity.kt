package org.hakandindis.cryptoapp.data.local.model.coin

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coins")
data class CoinEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val name: String?,
    val symbol: String?,
    val price: Double?,
)