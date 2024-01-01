package org.hakandindis.cryptoapp.scene.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.hakandindis.cryptoapp.base.BaseViewModel
import org.hakandindis.cryptoapp.core.Result
import org.hakandindis.cryptoapp.domain.usecase.home.GetLatestCoinsUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getLatestCoinsUseCase: GetLatestCoinsUseCase
) : BaseViewModel() {

    private var _coins: MutableLiveData<List<CoinItem>?> = MutableLiveData()
    val coins: LiveData<List<CoinItem>?> get() = _coins

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean> get() = _isLoading

    init {
        _isLoading.value = false
    }

    fun getLatestCoins() = viewModelScope.launch {
        _isLoading.value = true
        when (val result = getLatestCoinsUseCase()) {
            is Result.Success -> {
                _isLoading.value = false
                _coins.value = result.data
            }

            is Result.Failure -> {
                _isLoading.value = false
            }
        }
    }
}