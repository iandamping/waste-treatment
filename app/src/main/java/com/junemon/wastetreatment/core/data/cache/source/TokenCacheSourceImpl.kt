package com.junemon.wastetreatment.core.data.cache.source

import com.junemon.wastetreatment.core.data.cache.preference.PreferenceHelper
import javax.inject.Inject

class TokenCacheSourceImpl @Inject constructor(private val preferenceHelper: PreferenceHelper) :
    TokenCacheSource {

    companion object {
        private const val USER_TOKEN_KEY = "user token"
    }

    override fun saveToken(token: String) {
        preferenceHelper.saveStringInSharedPreference(USER_TOKEN_KEY, token)
    }

    override fun getToken(): String {
        return preferenceHelper.getStringInSharedPreference(USER_TOKEN_KEY)
    }
}