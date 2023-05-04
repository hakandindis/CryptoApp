package org.hakandindis.cryptoapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.hakandindis.cryptoapp.data.local.dao.CoinDao
import org.hakandindis.cryptoapp.data.remote.service.CoinService
import org.hakandindis.cryptoapp.scene.detail.DetailRepository
import org.hakandindis.cryptoapp.scene.home.HomeRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideHomeRepository(coinService: CoinService, coinDao: CoinDao) =
        HomeRepository(coinService, coinDao)

    @Singleton
    @Provides
    fun provideDetailRepository(coinService: CoinService) = DetailRepository(coinService)
}