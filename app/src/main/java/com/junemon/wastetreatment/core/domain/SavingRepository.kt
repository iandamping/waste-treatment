package com.junemon.wastetreatment.core.domain

import com.junemon.wastetreatment.core.domain.model.HistorySaving
import com.junemon.wastetreatment.core.domain.model.ItemSaving
import com.junemon.wastetreatment.core.domain.model.SummarySaving
import com.junemon.wastetreatment.core.domain.model.common.DomainResult
import com.junemon.wastetreatment.core.domain.model.common.VoidDomainResult

interface SavingRepository {

    suspend fun getSummary(): DomainResult<SummarySaving>

    suspend fun getHistory(): DomainResult<HistorySaving>

    suspend fun addSaving(request: List<ItemSaving>): VoidDomainResult
}