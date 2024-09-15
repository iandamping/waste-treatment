package com.junemon.wastetreatment.core.domain.model

import com.junemon.wastetreatment.core.data.model.response.ItemHistoryResponse
import com.junemon.wastetreatment.core.data.model.response.ItemWasteHistoryResponse

data class HistorySaving(
    val currentPage: Int,
    val limit: Int,
    val total: Int,
    val pageCurrent: Int,
    val pageTotal: Int,
    val historyItem: List<ItemHistory>
)

data class ItemHistory(
    val invoiceNo: String,
    val date: String,
    val collectorName: String,
    val collectorAmount: Int,
    val citizenName: String,
    val citizenAmount: Int,
    val amountTotal: Int,
    val wasteItem: List<ItemWasteHistory>
)

data class ItemWasteHistory(
    val wasteName: String,
    val unit: String,
    val quantity: Int,
)


fun List<ItemHistoryResponse>.mapItemHistory(): List<ItemHistory> = map { item ->
    ItemHistory(
        invoiceNo = item.invoiceNo,
        date = item.date,
        collectorName = item.collectorName,
        collectorAmount = item.collectorAmount,
        citizenName = item.citizenName,
        citizenAmount = item.citizenAmount,
        amountTotal = item.amountTotal,
        wasteItem = item.wasteItem.mapItemWasteHistory()
    )
}

fun List<ItemWasteHistoryResponse>.mapItemWasteHistory(): List<ItemWasteHistory> = map { item ->
    ItemWasteHistory(wasteName = item.wasteName, unit = item.unit, quantity = item.quantity)
}