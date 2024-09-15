package com.junemon.wastetreatment.di

import com.junemon.wastetreatment.core.data.cache.source.SavingCacheSource
import com.junemon.wastetreatment.core.data.cache.source.SavingCacheSourceImpl
import com.junemon.wastetreatment.core.data.cache.source.TokenCacheSource
import com.junemon.wastetreatment.core.data.cache.source.TokenCacheSourceImpl
import com.junemon.wastetreatment.core.data.cache.source.WasteCacheSource
import com.junemon.wastetreatment.core.data.cache.source.WasteCacheSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface CacheSourceModule {

    @Binds
    fun bindsTokenCacheSource(impl: TokenCacheSourceImpl): TokenCacheSource

    @Binds
    fun bindsSavingCacheSource(impl: SavingCacheSourceImpl): SavingCacheSource

    @Binds
    fun bindsWasteCacheSource(impl: WasteCacheSourceImpl): WasteCacheSource
}