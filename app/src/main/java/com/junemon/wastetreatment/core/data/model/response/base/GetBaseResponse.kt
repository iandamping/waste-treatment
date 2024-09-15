package com.junemon.wastetreatment.core.data.model.response.base

import com.squareup.moshi.Json

data class GetBaseResponse<out T>(
    @Json(name = "message")
    val message: String,
    @Json(name = "message_code")
    val messageCode: String,
    @Json(name = "data")
    val data: T?,
)
