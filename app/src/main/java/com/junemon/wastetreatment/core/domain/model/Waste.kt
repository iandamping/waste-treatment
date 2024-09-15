package com.junemon.wastetreatment.core.domain.model

import com.junemon.wastetreatment.core.data.model.response.ItemWasteResponse

data class Waste(
    val id: String,
    val name: String,
    val priceCollector: Int,
    val priceCitizen: Int,
    val priceTotal: Int,
    val image: String,
)

fun List<ItemWasteResponse>.mapItemWaste(): List<Waste> = map { item ->
    Waste(
        id = item.id,
        name = item.name,
        priceCollector = item.priceCollector,
        priceCitizen = item.priceCitizen,
        priceTotal = item.priceTotal,
        image = item.image
    )
}