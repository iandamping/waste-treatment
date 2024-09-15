package com.junemon.wastetreatment.core.data.cache.source

import com.junemon.wastetreatment.core.data.cache.preference.PreferenceHelper
import com.junemon.wastetreatment.core.data.model.response.WasteResponse
import com.junemon.wastetreatment.util.parser.MoshiParser
import com.squareup.moshi.Types
import javax.inject.Inject

class WasteCacheSourceImpl @Inject constructor(
    private val preferenceHelper: PreferenceHelper,
    private val moshiParser: MoshiParser
) : WasteCacheSource {

    companion object {
        private const val WASTE_KEY = "waste key"
    }

    override fun saveWaste(data: WasteResponse) {
        val types =
            Types.newParameterizedType(
                WasteResponse::class.java,
                String::class.java
            )
        val result = moshiParser.toJson(data, types)
        preferenceHelper.saveStringInSharedPreference(WASTE_KEY, result)
    }

    override fun getWaste(): WasteResponse? {
        val types = Types.newParameterizedType(
            WasteResponse::class.java, WasteResponse::class.java
        )
        val cache = preferenceHelper.getStringInSharedPreference(WASTE_KEY)
        val result = moshiParser.fromJson<WasteResponse>(cache, types)
        return result
    }
}