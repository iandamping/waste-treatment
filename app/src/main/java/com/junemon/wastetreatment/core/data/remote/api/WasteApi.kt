package com.junemon.wastetreatment.core.data.remote.api

import com.junemon.wastetreatment.core.data.model.request.AddSavingRequest
import com.junemon.wastetreatment.core.data.model.request.LoginRequest
import com.junemon.wastetreatment.core.data.model.response.base.GetBaseResponse
import com.junemon.wastetreatment.core.data.model.response.HistoryResponse
import com.junemon.wastetreatment.core.data.model.response.base.PostBaseResponse
import com.junemon.wastetreatment.core.data.model.response.SummaryResponse
import com.junemon.wastetreatment.core.data.model.response.TokenResponse
import com.junemon.wastetreatment.core.data.model.response.WasteResponse
import com.junemon.wastetreatment.core.data.remote.api.WasteApi.NetworkConstant.ADD_SAVING
import com.junemon.wastetreatment.core.data.remote.api.WasteApi.NetworkConstant.HISTORY
import com.junemon.wastetreatment.core.data.remote.api.WasteApi.NetworkConstant.LOGIN
import com.junemon.wastetreatment.core.data.remote.api.WasteApi.NetworkConstant.SUMMARY
import com.junemon.wastetreatment.core.data.remote.api.WasteApi.NetworkConstant.WASTE_LIST
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface WasteApi {

    object NetworkConstant {
        const val cacheSize = 10L * 1024 * 1024 // 10MB
        const val BASE_URL = ""
        const val LOGIN = "auth"
        const val SUMMARY = "api/v1/saving/summary"
        const val HISTORY = "api/v1/saving/list/1/10"
        const val ADD_SAVING = "api/v1/saving"
        const val WASTE_LIST = "api/v1/limbah/list"
    }

    @POST(LOGIN)
    suspend fun login(
        @Body request: LoginRequest
    ): Response<PostBaseResponse<TokenResponse>>

    @GET(SUMMARY)
    suspend fun getSummary(): Response<GetBaseResponse<SummaryResponse>>

    @GET(HISTORY)
    suspend fun getHistory(): Response<GetBaseResponse<HistoryResponse>>

    @POST(ADD_SAVING)
    suspend fun addSaving(@Body request: AddSavingRequest): Response<PostBaseResponse<Nothing>>

    @POST(WASTE_LIST)
    suspend fun getWaste(): Response<GetBaseResponse<WasteResponse>>
}