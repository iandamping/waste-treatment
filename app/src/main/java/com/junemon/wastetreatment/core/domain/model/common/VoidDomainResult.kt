package com.junemon.wastetreatment.core.domain.model.common

sealed class VoidDomainResult {

    data object Success : VoidDomainResult()

    data class Error(val errorMessage: String) : VoidDomainResult()
}
