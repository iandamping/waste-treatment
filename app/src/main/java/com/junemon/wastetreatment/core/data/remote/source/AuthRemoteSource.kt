package com.junemon.wastetreatment.core.data.remote.source

import com.junemon.wastetreatment.core.data.model.common.DataSourceResult
import com.junemon.wastetreatment.core.data.model.request.LoginRequest
import com.junemon.wastetreatment.core.data.model.response.TokenResponse

interface AuthRemoteSource {

    suspend fun login(request: LoginRequest): DataSourceResult<TokenResponse>
}