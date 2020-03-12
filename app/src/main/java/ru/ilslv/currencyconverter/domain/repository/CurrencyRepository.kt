package ru.ilslv.currencyconverter.domain.repository

import ru.ilslv.currencyconverter.data.remote.model.CurrencyRatesResponse
import ru.ilslv.currencyconverter.domain.model.CurrencyRatesModel

interface CurrencyRepository {
    suspend fun loadCurrencyRates(baseCurrencyKey: String): CurrencyRatesModel?
}