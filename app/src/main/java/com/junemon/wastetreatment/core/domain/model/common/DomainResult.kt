package com.junemon.wastetreatment.core.domain.model.common

sealed class DomainResult<out T> {

    data class Success<out T>(val data: T) : DomainResult<T>()

    data class Error(val errorMessage: String) : DomainResult<Nothing>()
}
