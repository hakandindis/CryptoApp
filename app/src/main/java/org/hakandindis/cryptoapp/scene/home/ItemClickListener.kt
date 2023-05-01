package org.hakandindis.cryptoapp.scene.home

import org.hakandindis.cryptoapp.data.remote.model.coin.Coin

interface ItemClickListener {
    fun onItemClick(coin: Coin)

    fun onSaveClick(coin: Coin)
}