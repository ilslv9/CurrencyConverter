package ru.ilslv.currencyconverter.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.ilslv.currencyconverter.data.repository.CurrencyRepositoryImpl
import ru.ilslv.currencyconverter.domain.usecase.ConvertCurrencyUseCase
import ru.ilslv.currencyconverter.domain.repository.CurrencyRepository
import ru.ilslv.currencyconverter.presentation.MainViewModel

val currencyConverterFeatureModule = module {
    single<CurrencyRepository> {
        CurrencyRepositoryImpl(
            get()
        )
    }
    single { ConvertCurrencyUseCase((get())) }
    viewModel { MainViewModel(get()) }
}