package com.junemon.wastetreatment.core.domain

import com.junemon.wastetreatment.core.domain.model.Waste
import com.junemon.wastetreatment.core.domain.model.common.DomainResult

interface WasteRepository {

    suspend fun getWaste(): DomainResult<List<Waste>>
}