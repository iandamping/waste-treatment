package com.junemon.wastetreatment.core.data.remote

import com.junemon.wastetreatment.R
import com.junemon.wastetreatment.core.data.model.common.RemoteGetResult
import com.junemon.wastetreatment.core.data.model.common.RemotePostResult
import com.junemon.wastetreatment.core.data.model.response.base.GetBaseResponse
import com.junemon.wastetreatment.core.data.model.response.base.PostBaseResponse
import com.junemon.wastetreatment.util.UtilityHelper
import com.junemon.wastetreatment.util.testing.wrapEspressoIdlingResource
import retrofit2.Response
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

class RemoteHelperImpl @Inject constructor(private val utilityHelper: UtilityHelper) :
    RemoteHelper {

    override suspend fun <T> postCall(call: Response<PostBaseResponse<T>>): RemotePostResult<T> {
        wrapEspressoIdlingResource {
            return try {
                if (call.isSuccessful) {
                    RemotePostResult.Success(call.body())
                } else {
                    RemotePostResult.Error(
                        call.errorBody()?.string()
                            ?: utilityHelper.getString(R.string.default_error_message)
                    )
                }
            } catch (e: SocketException) {
                RemotePostResult.Error(e.message.toString())
            } catch (e: UnknownHostException) {
                RemotePostResult.Error(e.message.toString())
            } catch (e: SocketTimeoutException) {
                RemotePostResult.Error(e.message.toString())
            } catch (e: IllegalArgumentException) {
                RemotePostResult.Error(e.message.toString())
            }
        }
    }

    override suspend fun <T> getCall(call: Response<GetBaseResponse<T>>): RemoteGetResult<T> {
        wrapEspressoIdlingResource {
            return try {
                if (call.isSuccessful) {
                    RemoteGetResult.Success(call.body())
                } else {
                    RemoteGetResult.Error(
                        call.errorBody()?.string()
                            ?: utilityHelper.getString(R.string.default_error_message)
                    )
                }
            } catch (e: SocketException) {
                RemoteGetResult.Error(e.message.toString())
            } catch (e: UnknownHostException) {
                RemoteGetResult.Error(e.message.toString())
            } catch (e: SocketTimeoutException) {
                RemoteGetResult.Error(e.message.toString())
            } catch (e: IllegalArgumentException) {
                RemoteGetResult.Error(e.message.toString())
            }
        }
    }
}
