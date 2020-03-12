package ru.ilslv.currencyconverter.domain.repository

import ru.ilslv.currencyconverter.data.model.CurrencyRatesResponse

interface CurrencyRepository {
    suspend fun loadCurrencyRates(baseCurrencyKey: String): CurrencyRatesResponse
}