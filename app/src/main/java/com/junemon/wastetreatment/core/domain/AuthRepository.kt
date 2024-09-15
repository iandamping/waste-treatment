package com.junemon.wastetreatment.core.domain

import com.junemon.wastetreatment.core.domain.model.common.VoidDomainResult

interface AuthRepository {

    suspend fun login(email: String, password: String): VoidDomainResult
}