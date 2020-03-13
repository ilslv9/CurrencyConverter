package ru.ilslv.currencyconverter.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.ilslv.currencyconverter.data.db.entity.CurrencyRateEntity

@Database(entities = [CurrencyRateEntity::class], version = 1, exportSchema = false)
@TypeConverters(HashMapTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun currencyRatesDao(): CurrencyRatesDao
}