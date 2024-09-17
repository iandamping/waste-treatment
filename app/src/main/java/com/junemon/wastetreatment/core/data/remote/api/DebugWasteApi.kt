package com.junemon.wastetreatment.core.data.remote.api

import android.content.Context
import com.junemon.wastetreatment.R
import com.junemon.wastetreatment.core.data.model.request.AddSavingRequest
import com.junemon.wastetreatment.core.data.model.request.LoginRequest
import com.junemon.wastetreatment.core.data.model.response.HistoryResponse
import com.junemon.wastetreatment.core.data.model.response.SummaryResponse
import com.junemon.wastetreatment.core.data.model.response.TokenResponse
import com.junemon.wastetreatment.core.data.model.response.WasteResponse
import com.junemon.wastetreatment.core.data.model.response.base.GetBaseResponse
import com.junemon.wastetreatment.core.data.model.response.base.PostBaseResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import retrofit2.Response
import java.io.InputStream

class DebugWasteApi(
    private val context: Context,
    private val moshi: Moshi
) :
    WasteApi {

    private fun loadJsonFromRaw(resourceId: Int): String {
        val inputStream: InputStream = context.resources.openRawResource(resourceId)
        return inputStream.bufferedReader().use { it.readText() }
    }


    override suspend fun login(request: LoginRequest): Response<PostBaseResponse<TokenResponse>> {
        val source = loadJsonFromRaw(R.raw.success_auth)

        val type = Types.newParameterizedType(
            PostBaseResponse::class.java, TokenResponse::class.java
        )
        val jsonAdapter: JsonAdapter<PostBaseResponse<TokenResponse>> =
            moshi.adapter<PostBaseResponse<TokenResponse>>(type).lenient()

        val result = jsonAdapter.fromJson(source)


        return Response.success(result)
    }

    override suspend fun getSummary(): Response<GetBaseResponse<SummaryResponse>> {
        val source = loadJsonFromRaw(R.raw.summary_response)
        val type = Types.newParameterizedType(
            GetBaseResponse::class.java, SummaryResponse::class.java
        )
        val jsonAdapter: JsonAdapter<GetBaseResponse<SummaryResponse>> =
            moshi.adapter<GetBaseResponse<SummaryResponse>>(type).lenient()

        val result = jsonAdapter.fromJson(source)


        return Response.success(result)
    }

    override suspend fun getHistory(): Response<GetBaseResponse<HistoryResponse>> {
        val source = loadJsonFromRaw(R.raw.history_response)
        val type = Types.newParameterizedType(
            GetBaseResponse::class.java, HistoryResponse::class.java
        )
        val jsonAdapter: JsonAdapter<GetBaseResponse<HistoryResponse>> =
            moshi.adapter<GetBaseResponse<HistoryResponse>>(type).lenient()

        val result = jsonAdapter.fromJson(source)


        return Response.success(result)
    }

    override suspend fun addSaving(request: AddSavingRequest): Response<PostBaseResponse<Nothing>> {
        val source = loadJsonFromRaw(R.raw.add_waste)
        val type = Types.newParameterizedType(
            PostBaseResponse::class.java, Nothing::class.java
        )
        val jsonAdapter: JsonAdapter<PostBaseResponse<Nothing>> =
            moshi.adapter<PostBaseResponse<Nothing>>(type).lenient()

        val result = jsonAdapter.fromJson(source)


        return Response.success(result)
    }

    override suspend fun getWaste(): Response<GetBaseResponse<WasteResponse>> {
        val source = loadJsonFromRaw(R.raw.waste_item)
        val type = Types.newParameterizedType(
            GetBaseResponse::class.java, WasteResponse::class.java
        )
        val jsonAdapter: JsonAdapter<GetBaseResponse<WasteResponse>> =
            moshi.adapter<GetBaseResponse<WasteResponse>>(type).lenient()

        val result = jsonAdapter.fromJson(source)


        return Response.success(result)
    }
}