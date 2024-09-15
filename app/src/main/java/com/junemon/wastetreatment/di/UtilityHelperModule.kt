package com.junemon.wastetreatment.di

import com.junemon.wastetreatment.util.UtilityHelper
import com.junemon.wastetreatment.util.UtilityHelperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface UtilityHelperModule {

    @Binds
    fun bindsUtilityHelper(impl: UtilityHelperImpl): UtilityHelper
}