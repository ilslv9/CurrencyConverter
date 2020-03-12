package ru.ilslv.currencyconverter.domain.base

sealed class Failure {
    data class ConvertCurrencyFailure(val error: Exception) : Failure()
}