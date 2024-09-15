package com.junemon.wastetreatment.di

import com.junemon.wastetreatment.core.domain.AuthRepository
import com.junemon.wastetreatment.core.domain.AuthRepositoryImpl
import com.junemon.wastetreatment.core.domain.SavingRepository
import com.junemon.wastetreatment.core.domain.SavingRepositoryImpl
import com.junemon.wastetreatment.core.domain.WasteRepository
import com.junemon.wastetreatment.core.domain.WasteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindsWasteRepository(impl: WasteRepositoryImpl): WasteRepository

    @Binds
    fun bindsAuthRepository(impl: AuthRepositoryImpl): AuthRepository

    @Binds
    fun bindsSavingRepository(impl: SavingRepositoryImpl): SavingRepository
}