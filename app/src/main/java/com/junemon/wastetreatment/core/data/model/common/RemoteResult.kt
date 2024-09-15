package com.junemon.wastetreatment.core.data.model.common

import com.junemon.wastetreatment.core.data.model.response.base.GetBaseResponse
import com.junemon.wastetreatment.core.data.model.response.base.PostBaseResponse

sealed class RemotePostResult<out T> {

    data class Success<T>(val data: PostBaseResponse<T>?) : RemotePostResult<T>()

    data class Error(val message: String) : RemotePostResult<Nothing>()
}

sealed class RemoteGetResult<out T> {

    data class Success<T>(val data: GetBaseResponse<T>?) : RemoteGetResult<T>()

    data class Error(val message: String) : RemoteGetResult<Nothing>()
}
