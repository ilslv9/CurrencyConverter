package ru.ilslv.currencyconverter.data.repository

import ru.ilslv.currencyconverter.data.remote.ServerApi
import ru.ilslv.currencyconverter.data.model.CurrencyRatesResponse
import ru.ilslv.currencyconverter.domain.repository.CurrencyRepository

class CurrencyRepositoryImpl(private val serverApi: ServerApi) :
    CurrencyRepository {

    override suspend fun loadCurrencyRates(baseCurrencyKey: String): CurrencyRatesResponse {
        return serverApi.loadCurrencyRatesAsync(baseCurrencyKey).await()
    }
}