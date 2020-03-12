package ru.ilslv.currencyconverter.data.remote.model

import com.google.gson.annotations.SerializedName
import ru.ilslv.currencyconverter.domain.model.CurrencyRatesModel

data class CurrencyRatesResponse(
    @SerializedName("base")
    val baseCurrency: String,
    val date: String,
    val rates: HashMap<String, Double>
)

fun CurrencyRatesResponse.mapToDomainModel(): CurrencyRatesModel =
    CurrencyRatesModel(this.baseCurrency, this.date, this.rates)
