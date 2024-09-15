package com.junemon.wastetreatment.core.data.model.response

import com.squareup.moshi.Json

data class SummaryResponse(
    @Json(name = "total_saving")
    val totalSaving: Int,
    @Json(name = "items")
    val summary: List<ItemSummaryResponse>
)

data class ItemSummaryResponse(
    @Json(name = "name")
    val name: String,
    @Json(name = "unit")
    val unit: String,
    @Json(name = "total_qty")
    val totalQuantity: Int,
    @Json(name = "total_amount")
    val totalAmount: Int,
    @Json(name = "image_url")
    val image: String,
)