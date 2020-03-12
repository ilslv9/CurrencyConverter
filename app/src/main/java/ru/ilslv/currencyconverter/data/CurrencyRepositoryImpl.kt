package ru.ilslv.currencyconverter.data

import ru.ilslv.currencyconverter.data.model.CurrencyRatesResponse
import ru.ilslv.currencyconverter.domain.CurrencyRepository

class CurrencyRepositoryImpl(private val serverApi: ServerApi) : CurrencyRepository {

    override suspend fun loadCurrencyRates(baseCurrencyKey: String): CurrencyRatesResponse {
        return serverApi.loadCurrencyRatesAsync(baseCurrencyKey).await()
    }
}