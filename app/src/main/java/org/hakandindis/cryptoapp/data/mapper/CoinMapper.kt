package org.hakandindis.cryptoapp.data.mapper

import org.hakandindis.cryptoapp.data.local.entity.CoinEntity
import org.hakandindis.cryptoapp.data.remote.model.coin.Coin
import org.hakandindis.cryptoapp.scene.home.CoinItem

/**
 * CREATED BY HAKAN DINDIŞ on 1.01.2024
 */
object CoinMapper {
    fun externalToItem(coin: Coin) = CoinItem(
        id = coin.id,
        name = coin.name,
        symbol = coin.symbol,
        price = coin.quote?.uSD?.price
    )

    fun entityToItem(entity: CoinEntity) = CoinItem(
        id = entity.id,
        name = entity.name,
        symbol = entity.symbol,
        price = entity.price
    )

    fun itemToEntity(item: CoinItem) = CoinEntity(
        id = item.id,
        name = item.name,
        symbol = item.symbol,
        price = item.price
    )
}