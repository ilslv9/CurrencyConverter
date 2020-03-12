package ru.ilslv.currencyconverter.data

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query
import ru.ilslv.currencyconverter.data.model.CurrencyRatesResponse

interface ServerApi {
    @GET("/latest")
    fun loadCurrencyRatesAsync(@Query("base") baseCurrency: String): Deferred<CurrencyRatesResponse>
}