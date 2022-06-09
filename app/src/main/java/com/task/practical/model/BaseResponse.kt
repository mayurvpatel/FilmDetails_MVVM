package com.task.practical.model

import com.google.gson.annotations.SerializedName


data class BaseResponse<T>(
    @SerializedName("error")
    val error: Int = 0,
    @SerializedName("msg")
    val message: String? = "",
    @SerializedName("data")
    val data: T,
)
