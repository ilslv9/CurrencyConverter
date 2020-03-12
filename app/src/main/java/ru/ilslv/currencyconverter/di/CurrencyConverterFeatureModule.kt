package ru.ilslv.currencyconverter.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.ilslv.currencyconverter.data.CurrencyRepositoryImpl
import ru.ilslv.currencyconverter.domain.ConvertCurrencyUseCase
import ru.ilslv.currencyconverter.domain.CurrencyRepository
import ru.ilslv.currencyconverter.presentation.MainViewModel

val currencyConverterFeatureModule = module {
    single<CurrencyRepository> { CurrencyRepositoryImpl(get()) }
    single { ConvertCurrencyUseCase((get())) }
    viewModel { MainViewModel(get()) }
}