package com.junemon.wastetreatment.core.data.remote.source

import com.junemon.wastetreatment.R
import com.junemon.wastetreatment.core.data.model.common.DataSourceResult
import com.junemon.wastetreatment.core.data.model.common.RemoteGetResult
import com.junemon.wastetreatment.core.data.model.response.WasteResponse
import com.junemon.wastetreatment.core.data.remote.RemoteHelper
import com.junemon.wastetreatment.core.data.remote.api.WasteApi
import com.junemon.wastetreatment.util.UtilityHelper
import javax.inject.Inject

class WasteRemoteSourceImpl @Inject constructor(
    private val api: WasteApi,
    private val utilityHelper: UtilityHelper,
    remoteHelper: RemoteHelper
) : WasteRemoteSource, RemoteHelper by remoteHelper {

    override suspend fun getWaste(): DataSourceResult<WasteResponse> {
        return when (val response = getCall(api.getWaste())) {
            is RemoteGetResult.Error -> DataSourceResult.Error(response.message)
            is RemoteGetResult.Success -> {
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