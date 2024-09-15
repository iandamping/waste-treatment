package com.junemon.wastetreatment.core.data.cache.source

interface TokenCacheSource {

    fun saveToken(token: String)

    fun getToken(): String
}