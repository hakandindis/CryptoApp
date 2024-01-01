package org.hakandindis.cryptoapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.hakandindis.cryptoapp.data.local.dao.CoinDao
import org.hakandindis.cryptoapp.data.remote.service.CoinService
import org.hakandindis.cryptoapp.data.repository.DetailRepositoryImpl
import org.hakandindis.cryptoapp.data.repository.FavoriteCoinsRepositoryImpl
import org.hakandindis.cryptoapp.data.repository.HomeRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideHomeRepository(coinService: CoinService, coinDao: CoinDao) = HomeRepositoryImpl(coinService)

    @Singleton
    @Provides
    fun provideDetailRepository(coinService: CoinService) = DetailRepositoryImpl(coinService)

    @Singleton
    @Provides
    fun provideFavoriteCoinsRepository(coinDao: CoinDao) = FavoriteCoinsRepositoryImpl(coinDao)
}