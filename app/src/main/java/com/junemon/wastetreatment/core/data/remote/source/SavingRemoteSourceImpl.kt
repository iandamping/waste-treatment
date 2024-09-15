package com.junemon.wastetreatment.core.data.remote.source

import com.junemon.wastetreatment.R
import com.junemon.wastetreatment.core.data.model.common.DataSourceResult
import com.junemon.wastetreatment.core.data.model.common.RemoteGetResult
import com.junemon.wastetreatment.core.data.model.common.RemotePostResult
import com.junemon.wastetreatment.core.data.model.common.VoiDataSourceResult
import com.junemon.wastetreatment.core.data.model.request.AddSavingRequest
import com.junemon.wastetreatment.core.data.model.response.HistoryResponse
import com.junemon.wastetreatment.core.data.model.response.SummaryResponse
import com.junemon.wastetreatment.core.data.remote.RemoteHelper
import com.junemon.wastetreatment.core.data.remote.api.WasteApi
import com.junemon.wastetreatment.util.UtilityHelper
import javax.inject.Inject

class SavingRemoteSourceImpl @Inject constructor(
    private val api: WasteApi,
    private val utilityHelper: UtilityHelper,
    remoteHelper: RemoteHelper
) : SavingRemoteSource, RemoteHelper by remoteHelper {

    override suspend fun getSummary(): DataSourceResult<SummaryResponse> {
        return when (val response = getCall(api.getSummary())) {
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

    override suspend fun getHistory(): DataSourceResult<HistoryResponse> {
        return when (val response = getCall(api.getHistory())) {
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

    override suspend fun addSaving(request: AddSavingRequest): VoiDataSourceResult {
        return when (val response = postCall(api.addSaving(request))) {
            is RemotePostResult.Error -> VoiDataSourceResult.Error(response.message)
            is RemotePostResult.Success -> {
                if (response.data == null) {
                    VoiDataSourceResult.Error(utilityHelper.getString(R.string.default_error_message))
                } else {
                    VoiDataSourceResult.Success
                }
            }
        }
    }
}