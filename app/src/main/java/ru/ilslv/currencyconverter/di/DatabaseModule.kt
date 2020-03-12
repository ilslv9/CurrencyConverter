package ru.ilslv.currencyconverter.di

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ru.ilslv.currencyconverter.data.db.AppDatabase

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "currency_rates_database"
        ).build()
    }
    single { get<AppDatabase>().currencyRatesDao() }
}