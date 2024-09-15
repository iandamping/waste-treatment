package com.junemon.wastetreatment.core.data.model.response

import com.squareup.moshi.Json

data class TokenResponse(
    @Json(name = "token")
    val token: String
)