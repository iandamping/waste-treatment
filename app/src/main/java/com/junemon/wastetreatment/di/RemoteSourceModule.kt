package com.junemon.wastetreatment.di

import com.junemon.wastetreatment.core.data.remote.source.AuthRemoteSource
import com.junemon.wastetreatment.core.data.remote.source.AuthRemoteSourceImpl
import com.junemon.wastetreatment.core.data.remote.source.SavingRemoteSource
import com.junemon.wastetreatment.core.data.remote.source.SavingRemoteSourceImpl
import com.junemon.wastetreatment.core.data.remote.source.WasteRemoteSource
import com.junemon.wastetreatment.core.data.remote.source.WasteRemoteSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RemoteSourceModule {

    @Binds
    fun bindsSavingRemoteSource(impl: SavingRemoteSourceImpl): SavingRemoteSource

    @Binds
    fun bindsAuthRemoteSource(impl: AuthRemoteSourceImpl): AuthRemoteSource

    @Binds
    fun bindsWasteRemoteSource(impl: WasteRemoteSourceImpl): WasteRemoteSource
}