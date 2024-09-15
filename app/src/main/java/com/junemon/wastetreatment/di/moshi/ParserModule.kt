package com.junemon.wastetreatment.di.moshi

import com.junemon.wastetreatment.util.parser.MoshiParser
import com.junemon.wastetreatment.util.parser.MoshiParserImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ParserModule {

    @Binds
    fun bindsMoshiParser(impl: MoshiParserImpl): MoshiParser
}
