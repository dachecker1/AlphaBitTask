package com.vk.alphabittask.data.network.response

import com.google.gson.annotations.SerializedName

class TransactionListResponse(
    @SerializedName("status") val status : String = "",
    @SerializedName("message") val message : String = "",
    @SerializedName("result") val transactions : List<TransactionEvent> = listOf()
)