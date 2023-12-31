package org.hakandindis.cryptoapp.scene.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.hakandindis.cryptoapp.base.BaseViewModel
import org.hakandindis.cryptoapp.data.remote.model.detail.DetailResponse
import org.hakandindis.cryptoapp.data.repository.DetailRepositoryImpl
import org.hakandindis.cryptoapp.util.Constants
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(private val detailRepository: DetailRepositoryImpl) :
    BaseViewModel() {

    val detailResponse: MutableLiveData<DetailResponse?> = MutableLiveData()


    fun getDetail(symbol: String) {
        viewModelScope.launch {
            detailResponse.value = detailRepository.getCoinDetail(Constants.API_KEY, symbol)
        }
    }
}