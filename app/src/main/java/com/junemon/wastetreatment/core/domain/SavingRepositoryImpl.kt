package com.junemon.wastetreatment.core.domain

import com.junemon.wastetreatment.R
import com.junemon.wastetreatment.core.data.cache.source.SavingCacheSource
import com.junemon.wastetreatment.core.data.model.common.DataSourceResult
import com.junemon.wastetreatment.core.data.model.common.VoiDataSourceResult
import com.junemon.wastetreatment.core.data.model.request.AddSavingRequest
import com.junemon.wastetreatment.core.data.remote.source.SavingRemoteSource
import com.junemon.wastetreatment.core.domain.model.HistorySaving
import com.junemon.wastetreatment.core.domain.model.ItemSaving
import com.junemon.wastetreatment.core.domain.model.SummarySaving
import com.junemon.wastetreatment.core.domain.model.common.DomainResult
import com.junemon.wastetreatment.core.domain.model.common.VoidDomainResult
import com.junemon.wastetreatment.core.domain.model.mapItemHistory
import com.junemon.wastetreatment.core.domain.model.mapItemSaving
import com.junemon.wastetreatment.core.domain.model.mapItemSummaryResponse
import com.junemon.wastetreatment.util.UtilityHelper
import javax.inject.Inject

class SavingRepositoryImpl @Inject constructor(
    private val remoteSource: SavingRemoteSource,
    private val cacheSource: SavingCacheSource,
    private val utilityHelper: UtilityHelper,
) : SavingRepository {
    override suspend fun getSummary(): DomainResult<SummarySaving> {
        return when (val response = remoteSource.getSummary()) {
            is DataSourceResult.Error -> DomainResult.Error(response.errorMessage)
            is DataSourceResult.Success -> {
                cacheSource.saveSummary(response.data)
                val cacheResult = cacheSource.getSummary()
                if (cacheResult == null) {
                    DomainResult.Error(utilityHelper.getString(R.string.default_error_message))
                } else {
                    DomainResult.Success(
                        SummarySaving(
                            totalSaving = cacheResult.totalSaving,
                            summary = cacheResult.summary.mapItemSummaryResponse()
                        )
                    )
                }
            }
        }
    }

    override suspend fun getHistory(): DomainResult<HistorySaving> {
        return when (val response = remoteSource.getHistory()) {
            is DataSourceResult.Error -> DomainResult.Error(response.errorMessage)
            is DataSourceResult.Success -> {
                cacheSource.saveHistory(response.data)
                val cacheResult = cacheSource.getHistory()
                if (cacheResult == null) {
                    DomainResult.Error(utilityHelper.getString(R.string.default_error_message))
                } else DomainResult.Success(
                    HistorySaving(
                        currentPage = cacheResult.currentPage,
                        limit = cacheResult.limit,
                        total = cacheResult.total,
                        pageCurrent = cacheResult.pageCurrent,
                        pageTotal = cacheResult.pageTotal,
                        historyItem = cacheResult.historyItem.mapItemHistory()
                    )
                )
            }
        }
    }

    override suspend fun addSaving(request: List<ItemSaving>): VoidDomainResult {
        return when (val response =
            remoteSource.addSaving(AddSavingRequest(request.mapItemSaving()))) {
            is VoiDataSourceResult.Error -> VoidDomainResult.Error(response.errorMessage)
            VoiDataSourceResult.Success -> VoidDomainResult.Success
        }
    }
}