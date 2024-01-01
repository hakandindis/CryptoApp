package org.hakandindis.cryptoapp.scene.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.hakandindis.cryptoapp.base.BaseViewModel
import org.hakandindis.cryptoapp.core.Result
import org.hakandindis.cryptoapp.domain.usecase.favorite.GetAllFavoriteCoinsUseCase
import org.hakandindis.cryptoapp.scene.home.CoinItem
import javax.inject.Inject

/**
 * CREATED BY HAKAN DINDIŞ on 1.01.2024
 */
class FavoriteCoinsViewModel @Inject constructor(
    private val getAllFavoriteCoinsUseCase: GetAllFavoriteCoinsUseCase
) : BaseViewModel() {

    private val _favoriteCoins: MutableLiveData<List<CoinItem>> = MutableLiveData()
    val favoriteCoins: LiveData<List<CoinItem>> get() = _favoriteCoins

    fun getAllFavoriteCoins() = viewModelScope.launch {
        when (val result = getAllFavoriteCoinsUseCase()) {
            is Result.Success -> {
                _favoriteCoins.value = result.data
            }

            is Result.Failure -> {

            }
        }
    }
}