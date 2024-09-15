package com.junemon.wastetreatment.core.data.remote.source

import com.junemon.wastetreatment.core.data.model.common.DataSourceResult
import com.junemon.wastetreatment.core.data.model.common.VoiDataSourceResult
import com.junemon.wastetreatment.core.data.model.request.AddSavingRequest
import com.junemon.wastetreatment.core.data.model.response.HistoryResponse
import com.junemon.wastetreatment.core.data.model.response.SummaryResponse

interface SavingRemoteSource {

    suspend fun getSummary(): DataSourceResult<SummaryResponse>

    suspend fun getHistory(): DataSourceResult<HistoryResponse>

    suspend fun addSaving(request: AddSavingRequest): VoiDataSourceResult
}