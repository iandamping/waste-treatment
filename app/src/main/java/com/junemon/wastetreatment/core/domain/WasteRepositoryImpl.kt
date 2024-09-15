package com.junemon.wastetreatment.core.domain

import com.junemon.wastetreatment.R
import com.junemon.wastetreatment.core.data.cache.source.WasteCacheSource
import com.junemon.wastetreatment.core.data.model.common.DataSourceResult
import com.junemon.wastetreatment.core.data.remote.source.WasteRemoteSource
import com.junemon.wastetreatment.core.domain.model.Waste
import com.junemon.wastetreatment.core.domain.model.common.DomainResult
import com.junemon.wastetreatment.core.domain.model.mapItemWaste
import com.junemon.wastetreatment.util.UtilityHelper
import javax.inject.Inject

class WasteRepositoryImpl @Inject constructor(
    private val remoteSource: WasteRemoteSource,
    private val cacheSource: WasteCacheSource,
    private val utilityHelper: UtilityHelper
) : WasteRepository {
    override suspend fun getWaste(): DomainResult<List<Waste>> {
        return when (val response = remoteSource.getWaste()) {
            is DataSourceResult.Error -> DomainResult.Error(response.errorMessage)
            is DataSourceResult.Success -> {
                cacheSource.saveWaste(response.data)
                val cacheResult = cacheSource.getWaste()
                if (cacheResult == null) {
                    DomainResult.Error(utilityHelper.getString(R.string.default_error_message))
                } else {
                    DomainResult.Success(cacheResult.itemWaste.mapItemWaste())
                }
            }
        }
    }
}