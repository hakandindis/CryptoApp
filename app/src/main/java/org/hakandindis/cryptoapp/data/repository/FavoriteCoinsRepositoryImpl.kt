package org.hakandindis.cryptoapp.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.hakandindis.cryptoapp.data.local.dao.CoinDao
import org.hakandindis.cryptoapp.data.local.entity.CoinEntity
import org.hakandindis.cryptoapp.domain.repository.FavoriteCoinsRepository
import javax.inject.Inject

/**
 * CREATED BY HAKAN DINDIŞ on 1.01.2024
 */
class FavoriteCoinsRepositoryImpl @Inject constructor(
    private val dao: CoinDao
) : FavoriteCoinsRepository {
    override suspend fun getAllFavoriteCoins(): List<CoinEntity>? = withContext(Dispatchers.IO) {
        return@withContext dao.getAllCoins()
    }
}