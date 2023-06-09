package org.hakandindis.cryptoapp.data.remote.model.detail


import com.google.gson.annotations.SerializedName

data class ContractAddres(
    @SerializedName("contract_address")
    val contractAddress: String?,
    @SerializedName("platform")
    val platform: Platform?
)