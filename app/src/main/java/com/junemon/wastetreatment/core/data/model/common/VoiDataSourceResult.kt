package com.junemon.wastetreatment.core.data.model.common

sealed class VoiDataSourceResult {

    data object Success : VoiDataSourceResult()

    data class Error(val errorMessage: String) : VoiDataSourceResult()
}
