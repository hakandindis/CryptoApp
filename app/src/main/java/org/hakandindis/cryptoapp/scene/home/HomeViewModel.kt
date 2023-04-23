package org.hakandindis.cryptoapp.scene.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.hakandindis.cryptoapp.base.BaseViewModel
import org.hakandindis.cryptoapp.data.remote.model.coin.Coin
import org.hakandindis.cryptoapp.util.Constants
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeRepository: HomeRepository) :
    BaseViewModel() {

    private var _coins: MutableLiveData<List<Coin?>?> = MutableLiveData()
    val coins: LiveData<List<Coin?>?> get() = _coins

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean> get() = _isLoading

    init {
        _isLoading.value = false
    }

    fun getLatestCoins() {
        _isLoading.value = true
        viewModelScope.launch(coroutineContext) {
            _coins.value = homeRepository.getLatestCoins(Constants.API_KEY, Constants.LIMIT)
        }
    }
}