package com.junemon.wastetreatment.core.data.cache.source

import com.junemon.wastetreatment.core.data.model.response.WasteResponse

interface WasteCacheSource {

    fun saveWaste(data: WasteResponse)

    fun getWaste(): WasteResponse?
}