package ru.ilslv.currencyconverter.data.model

import com.google.gson.annotations.SerializedName

data class CurrencyRatesResponse(
    @SerializedName("base")
    val baseCurrency: String,
    val date: String,
    val rates: HashMap<String, Double>
)