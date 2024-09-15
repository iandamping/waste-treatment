package com.junemon.wastetreatment.core.data.remote.source

import com.junemon.wastetreatment.core.data.model.common.DataSourceResult
import com.junemon.wastetreatment.core.data.model.response.WasteResponse

interface WasteRemoteSource {

    suspend fun getWaste(): DataSourceResult<WasteResponse>
}