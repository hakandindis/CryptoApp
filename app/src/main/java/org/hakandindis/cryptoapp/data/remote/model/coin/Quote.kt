package org.hakandindis.cryptoapp.data.remote.model.coin


import com.google.gson.annotations.SerializedName

data class Quote(
    @SerializedName("USD")
    val uSD: USD?
)