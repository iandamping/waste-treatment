package com.junemon.wastetreatment.core.domain.model

import com.junemon.wastetreatment.core.data.model.request.ItemSavingRequest

data class ItemSaving(
    val itemId: String,
    val itemQty: Int,
)

fun List<ItemSaving>.mapItemSaving(): List<ItemSavingRequest> = map { item ->
    ItemSavingRequest(itemId = item.itemId, itemQty = item.itemQty)
}