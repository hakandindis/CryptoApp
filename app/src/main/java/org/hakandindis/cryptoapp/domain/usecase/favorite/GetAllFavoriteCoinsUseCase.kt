package org.hakandindis.cryptoapp.domain.usecase.favorite

import org.hakandindis.cryptoapp.core.Result
import org.hakandindis.cryptoapp.data.mapper.CoinMapper
import org.hakandindis.cryptoapp.data.repository.FavoriteCoinsRepositoryImpl
import org.hakandindis.cryptoapp.scene.home.CoinItem
import javax.inject.Inject

/**
 * CREATED BY HAKAN DINDIŞ on 1.01.2024
 */
class GetAllFavoriteCoinsUseCase @Inject constructor(
    private val repository: FavoriteCoinsRepositoryImpl
) {
    suspend operator fun invoke(): Result<List<CoinItem>> {
        return try {
            val entities = repository.getAllFavoriteCoins()
            val items = entities?.map { CoinMapper.entityToItem(it) }?.toList() ?: listOf()
            Result.Success(items)
        } catch (e: Exception) {
            Result.Failure(e)
        }
    }
}