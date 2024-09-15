package com.junemon.wastetreatment.core.data.model.request

import com.squareup.moshi.Json

data class AddSavingRequest(
    @Json(name = "items")
    val listItem: List<ItemSavingRequest>
)

data class ItemSavingRequest(
    @Json(name = "item_id")
    val itemId: String,
    @Json(name = "qty")
    val itemQty: Int,
)
