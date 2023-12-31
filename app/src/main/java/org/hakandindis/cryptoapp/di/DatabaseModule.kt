package org.hakandindis.cryptoapp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.hakandindis.cryptoapp.data.db.CryptoDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    private const val DATABASE_NAME = "crypto_database"

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context = context,
        klass = CryptoDatabase::class.java,
        name = DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    fun provideCoinDao(database: CryptoDatabase) = database.coinDao()
}