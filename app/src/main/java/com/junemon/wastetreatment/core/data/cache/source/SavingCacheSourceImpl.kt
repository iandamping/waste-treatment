package com.junemon.wastetreatment.core.data.cache.source

import com.junemon.wastetreatment.core.data.cache.preference.PreferenceHelper
import com.junemon.wastetreatment.core.data.model.response.HistoryResponse
import com.junemon.wastetreatment.core.data.model.response.SummaryResponse
import com.junemon.wastetreatment.util.parser.MoshiParser
import com.squareup.moshi.Types
import javax.inject.Inject

class SavingCacheSourceImpl @Inject constructor(
    private val preferenceHelper: PreferenceHelper,
    private val moshiParser: MoshiParser
) :
    SavingCacheSource {

    companion object {
        private const val SUMMARY_KEY = "summary key"
        private const val HISTORY_KEY = "history key"
    }

    override fun saveSummary(data: SummaryResponse) {
        val types =
            Types.newParameterizedType(
                SummaryResponse::class.java,
                String::class.java
            )
        val result = moshiParser.toJson(data, types)
        preferenceHelper.saveStringInSharedPreference(SUMMARY_KEY, result)
    }

    override fun saveHistory(data: HistoryResponse) {
        val types =
            Types.newParameterizedType(
                HistoryResponse::class.java,
                String::class.java
            )
        val result = moshiParser.toJson(data, types)
        preferenceHelper.saveStringInSharedPreference(HISTORY_KEY, result)
    }

    override fun getSummary(): SummaryResponse? {
        val types = Types.newParameterizedType(
            SummaryResponse::class.java, SummaryResponse::class.java
        )
        val cache = preferenceHelper.getStringInSharedPreference(SUMMARY_KEY)
        val result = moshiParser.fromJson<SummaryResponse>(cache, types)
        return result
    }

    override fun getHistory(): HistoryResponse? {
        val types = Types.newParameterizedType(
            HistoryResponse::class.java, HistoryResponse::class.java
        )
        val cache = preferenceHelper.getStringInSharedPreference(HISTORY_KEY)
        val result = moshiParser.fromJson<HistoryResponse>(cache, types)
        return result
    }
}