package ru.ilslv.currencyconverter.domain

import ru.ilslv.currencyconverter.data.model.CurrencyRatesResponse

interface CurrencyRepository {
    suspend fun loadCurrencyRates(baseCurrencyKey: String): CurrencyRatesResponse
}