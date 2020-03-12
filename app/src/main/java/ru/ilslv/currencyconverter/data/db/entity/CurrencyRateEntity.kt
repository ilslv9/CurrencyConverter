package ru.ilslv.currencyconverter.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import ru.ilslv.currencyconverter.data.db.HashMapTypeConverter
import ru.ilslv.currencyconverter.domain.model.CurrencyRatesModel

@Entity(tableName = "currency_rates")
data class CurrencyRateEntity(
    @PrimaryKey
    val baseCurrency: String,
    val date: String,
    @TypeConverters(HashMapTypeConverter::class)
    val rates: Map<String, Double>
)

fun CurrencyRateEntity.mapToDomainModel(): CurrencyRatesModel =
    CurrencyRatesModel(this.baseCurrency, this.date, this.rates)