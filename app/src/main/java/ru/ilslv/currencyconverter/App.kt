package ru.ilslv.currencyconverter

import android.app.Application
import org.koin.core.context.startKoin
import ru.ilslv.currencyconverter.di.currencyConverterFeatureModule
import ru.ilslv.currencyconverter.di.networkModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin { modules(listOf(networkModule, currencyConverterFeatureModule)) }
    }
}