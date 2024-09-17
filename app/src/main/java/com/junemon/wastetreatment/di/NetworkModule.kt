package com.junemon.wastetreatment.di

import android.content.Context
import com.junemon.wastetreatment.BuildConfig
import com.junemon.wastetreatment.core.data.remote.api.DebugWasteApi
import com.junemon.wastetreatment.core.data.remote.api.WasteApi
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = ""
    private const val DEBUG_NON_API_VERSION = "debug-non-api"

    @Provides
    fun provideHttpClient(): OkHttpClient {
        val logInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val builder = OkHttpClient.Builder()
            .addInterceptor(logInterceptor)

        return builder.build()
    }

    @Provides
    @Singleton
    fun provideWasteApiInterface(
        @ApplicationContext context: Context,
        okHttpClient: OkHttpClient,
        moshi: Moshi
    ): WasteApi {
        return if (BuildConfig.BUILD_TYPE == DEBUG_NON_API_VERSION) {
            DebugWasteApi(context, moshi)
        } else {
            Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .baseUrl(BASE_URL)
                .build()
                .create(WasteApi::class.java)
        }

    }
}