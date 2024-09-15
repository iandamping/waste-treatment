package com.junemon.wastetreatment.core.data.model.common

sealed class DataSourceResult<out T> {

    data class Success<out T>(val data: T) : DataSourceResult<T>()

    data class Error(val errorMessage: String) : DataSourceResult<Nothing>()

}
