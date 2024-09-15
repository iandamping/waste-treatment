package com.junemon.wastetreatment.core.data.model.response

import com.squareup.moshi.Json

data class WasteResponse(
    @Json(name = "items")
    val itemWaste: List<ItemWasteResponse>,
)

data class ItemWasteResponse(
    @Json(name = "id")
    val id: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "price_pengepul")
    val priceCollector: Int,
    @Json(name = "price_warga")
    val priceCitizen: Int,
    @Json(name = "price_total")
    val priceTotal: Int,
    @Json(name = "image_url")
    val image: String,
)