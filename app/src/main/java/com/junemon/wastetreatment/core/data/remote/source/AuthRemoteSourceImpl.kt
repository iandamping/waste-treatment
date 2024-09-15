package com.junemon.wastetreatment.core.data.remote.source

import com.junemon.wastetreatment.R
import com.junemon.wastetreatment.core.data.model.common.DataSourceResult
import com.junemon.wastetreatment.core.data.model.common.RemotePostResult
import com.junemon.wastetreatment.core.data.model.request.LoginRequest
import com.junemon.wastetreatment.core.data.model.response.TokenResponse
import com.junemon.wastetreatment.core.data.remote.RemoteHelper
import com.junemon.wastetreatment.core.data.remote.api.WasteApi
import com.junemon.wastetreatment.util.UtilityHelper
import javax.inject.Inject

class AuthRemoteSourceImpl @Inject constructor(
    private val api: WasteApi,
    private val utilityHelper: UtilityHelper,
    remoteHelper: RemoteHelper
) : AuthRemoteSource, RemoteHelper by remoteHelper {

    override suspend fun login(request: LoginRequest): DataSourceResult<TokenResponse> {
        return when (val response = postCall(api.login(request))) {
            is RemotePostResult.Error -> DataSourceResult.Error(response.message)
            is RemotePostResult.Success -> {
                if (response.data == null) {
                    DataSourceResult.Error(utilityHelper.getString(R.string.default_error_message))
                } else {
                    if (response.data.data != null) {
                        DataSourceResult.Success(response.data.data)
                    } else {
                        DataSourceResult.Error(utilityHelper.getString(R.string.default_error_message))
                    }
                }
            }
        }
    }
}