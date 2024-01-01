package org.hakandindis.cryptoapp.domain.usecase.home

import org.hakandindis.cryptoapp.core.Result
import org.hakandindis.cryptoapp.data.remote.model.coin.Coin
import org.hakandindis.cryptoapp.data.repository.HomeRepositoryImpl
import org.hakandindis.cryptoapp.util.Constants
import javax.inject.Inject

/**
 * CREATED BY HAKAN DINDIŞ on 1.01.2024
 */
class GetLatestCoinsUseCase @Inject constructor(
    private val repository: HomeRepositoryImpl
) {
    suspend operator fun invoke(): Result<List<Coin?>> {
        return try {
            val coins = repository.getLatestCoins(Constants.API_KEY, Constants.LIMIT) ?: listOf()
            Result.Success(coins)
        } catch (e: Exception) {
            Result.Failure(e)
        }
    }
}