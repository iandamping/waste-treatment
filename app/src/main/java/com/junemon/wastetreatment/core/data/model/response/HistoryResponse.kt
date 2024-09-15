package com.junemon.wastetreatment.core.data.model.response

import com.squareup.moshi.Json

data class HistoryResponse(
    @Json(name = "data_current_page")
    val currentPage: Int,
    @Json(name = "limit")
    val limit: Int,
    @Json(name = "total")
    val total: Int,
    @Json(name = "page_current")
    val pageCurrent: Int,
    @Json(name = "page_total")
    val pageTotal: Int,
    @Json(name = "list")
    val historyItem: List<ItemHistoryResponse>
)

data class ItemHistoryResponse(
    @Json(name = "invoice_no")
    val invoiceNo: String,
    @Json(name = "date")
    val date: String,
    @Json(name = "pengepul_name")
    val collectorName: String,
    @Json(name = "amount_pengepul")
    val collectorAmount: Int,
    @Json(name = "warga_name")
    val citizenName: String,
    @Json(name = "amount_warga")
    val citizenAmount: Int,
    @Json(name = "amount_total")
    val amountTotal: Int,
    @Json(name = "items")
    val wasteItem: List<ItemWasteHistoryResponse>
)

data class ItemWasteHistoryResponse(
    @Json(name = "name")
    val wasteName: String,
    @Json(name = "unit")
    val unit: String,
    @Json(name = "qty")
    val quantity: Int,
)
