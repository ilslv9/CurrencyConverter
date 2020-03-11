package ru.ilslv.currencyconverter.data.model

import com.google.gson.annotations.SerializedName

data class CurrencyRatesResponse(
    @SerializedName("base_currency")
    val baseCurrency: String,
    val time: String,
    val rates: HashMap<String, Double>
)