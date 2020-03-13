package ru.ilslv.currencyconverter.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.ilslv.currencyconverter.data.db.entity.CurrencyRateEntity

@Dao
interface CurrencyRatesDao {

    @Query("SELECT * FROM currency_rates WHERE baseCurrency LIKE :baseCurrency")
    suspend fun findByBaseCurrency(baseCurrency: String): CurrencyRateEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrencyRate(currencyRateEntity: CurrencyRateEntity)

}