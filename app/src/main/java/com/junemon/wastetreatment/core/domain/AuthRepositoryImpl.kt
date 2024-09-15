package com.junemon.wastetreatment.core.domain

import com.junemon.wastetreatment.core.data.cache.source.TokenCacheSource
import com.junemon.wastetreatment.core.data.model.common.DataSourceResult
import com.junemon.wastetreatment.core.data.model.request.LoginRequest
import com.junemon.wastetreatment.core.data.remote.source.AuthRemoteSource
import com.junemon.wastetreatment.core.domain.model.common.VoidDomainResult
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val cacheSource: TokenCacheSource,
    private val remoteSource: AuthRemoteSource
) : AuthRepository {

    override suspend fun login(email: String, password: String): VoidDomainResult {
        return when (val response = remoteSource.login(LoginRequest(email, password))) {
            is DataSourceResult.Error -> VoidDomainResult.Error(response.errorMessage)
            is DataSourceResult.Success -> {
                cacheSource.saveToken(response.data.token)
                VoidDomainResult.Success
            }
        }
    }
}