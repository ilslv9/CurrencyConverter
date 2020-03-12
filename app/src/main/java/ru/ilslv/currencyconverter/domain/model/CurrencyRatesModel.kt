package ru.ilslv.currencyconverter.domain.model

import androidx.room.PrimaryKey

data class CurrencyRatesModel(
    val baseCurrency: String,
    val date: String,
    val rates: Map<String, Double>
)