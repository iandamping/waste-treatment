package com.junemon.wastetreatment.core.data.remote

import com.junemon.wastetreatment.core.data.model.common.RemoteGetResult
import com.junemon.wastetreatment.core.data.model.common.RemotePostResult
import com.junemon.wastetreatment.core.data.model.response.base.GetBaseResponse
import com.junemon.wastetreatment.core.data.model.response.base.PostBaseResponse
import retrofit2.Response

interface RemoteHelper {

    suspend fun <T> postCall(call: Response<PostBaseResponse<T>>): RemotePostResult<T>

    suspend fun <T> getCall(call: Response<GetBaseResponse<T>>): RemoteGetResult<T>
}
