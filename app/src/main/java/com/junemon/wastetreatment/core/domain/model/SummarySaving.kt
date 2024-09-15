package com.junemon.wastetreatment.core.domain.model

import com.junemon.wastetreatment.core.data.model.response.ItemSummaryResponse

data class SummarySaving(
    val totalSaving: Int,
    val summary: List<ItemSummary>
)

data class ItemSummary(
    val name: String,
    val unit: String,
    val totalQuantity: Int,
    val totalAmount: Int,
    val image: String,
)

fun List<ItemSummaryResponse>.mapItemSummaryResponse(): List<ItemSummary> = map { item ->
    ItemSummary(
        name = item.name,
        unit = item.unit,
        totalQuantity = item.totalQuantity,
        totalAmount = item.totalAmount,
        image = item.image
    )
}