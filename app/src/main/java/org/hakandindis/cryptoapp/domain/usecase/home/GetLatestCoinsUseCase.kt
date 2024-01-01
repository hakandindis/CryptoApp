package org.hakandindis.cryptoapp.domain.usecase.home

import org.hakandindis.cryptoapp.core.Result
import org.hakandindis.cryptoapp.data.mapper.CoinMapper
import org.hakandindis.cryptoapp.data.repository.HomeRepositoryImpl
import org.hakandindis.cryptoapp.scene.home.CoinItem
import org.hakandindis.cryptoapp.util.Constants
import javax.inject.Inject

/**
 * CREATED BY HAKAN DINDIŞ on 1.01.2024
 */
class GetLatestCoinsUseCase @Inject constructor(
    private val repository: HomeRepositoryImpl
) {
    suspend operator fun invoke(): Result<List<CoinItem>> {
        return try {
            val coins = repository.getLatestCoins(Constants.API_KEY, Constants.LIMIT)
            val items = coins?.map { CoinMapper.externalToItem(it) }?.toList() ?: listOf()
            Result.Success(items)
        } catch (e: Exception) {
            Result.Failure(e)
        }
    }
}