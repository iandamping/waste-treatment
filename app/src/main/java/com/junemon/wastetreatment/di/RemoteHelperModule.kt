package com.junemon.wastetreatment.di

import com.junemon.wastetreatment.core.data.remote.RemoteHelper
import com.junemon.wastetreatment.core.data.remote.RemoteHelperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RemoteHelperModule {

    @Binds
    fun bindsRemoteHelper(impl: RemoteHelperImpl): RemoteHelper
}
