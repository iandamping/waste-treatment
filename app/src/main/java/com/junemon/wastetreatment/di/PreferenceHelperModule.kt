package com.junemon.wastetreatment.di

import com.junemon.wastetreatment.core.data.cache.preference.PreferenceHelper
import com.junemon.wastetreatment.core.data.cache.preference.PreferenceHelperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface PreferenceHelperModule {

    @Binds
    fun bindsPreferenceHelper(impl: PreferenceHelperImpl): PreferenceHelper
}
