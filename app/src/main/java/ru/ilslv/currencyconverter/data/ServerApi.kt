package ru.ilslv.currencyconverter.data

import kotlinx.coroutines.Deferred
import retrofit2.http.POST
import retrofit2.http.Query
import ru.ilslv.currencyconverter.data.model.CurrencyRatesResponse

interface ServerApi {
    @POST("/latest/")
    fun loadCurrencyRates(@Query("base") baseCurrency: String): Deferred<CurrencyRatesResponse>
}