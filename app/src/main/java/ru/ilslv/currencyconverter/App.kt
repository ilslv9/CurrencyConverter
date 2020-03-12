package ru.ilslv.currencyconverter

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.ilslv.currencyconverter.di.currencyConverterFeatureModule
import ru.ilslv.currencyconverter.di.databaseModule
import ru.ilslv.currencyconverter.di.networkModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(baseContext)
            modules(listOf(networkModule, currencyConverterFeatureModule, databaseModule))
        }
    }
}