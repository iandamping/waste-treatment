package com.junemon.wastetreatment.core.data.model.response.base

import com.squareup.moshi.Json

data class PostBaseResponse<out T>(
    @Json(name = "success")
    val isSuccess: Boolean,
    @Json(name = "message")
    val message: String,
    @Json(name = "message_code")
    val messageCode: String,
    @Json(name = "data")
    val data: T?,
)
