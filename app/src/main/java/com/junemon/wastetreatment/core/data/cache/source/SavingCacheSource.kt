package com.junemon.wastetreatment.core.data.cache.source

import com.junemon.wastetreatment.core.data.model.response.HistoryResponse
import com.junemon.wastetreatment.core.data.model.response.SummaryResponse

interface SavingCacheSource {

    fun saveSummary(data: SummaryResponse)

    fun saveHistory(data: HistoryResponse)

    fun getSummary(): SummaryResponse?

    fun getHistory(): HistoryResponse?


}