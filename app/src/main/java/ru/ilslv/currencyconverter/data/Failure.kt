package ru.ilslv.currencyconverter.data

sealed class Failure {
    data class ConvertCurrencyFailure(val error: Exception) : Failure()
}