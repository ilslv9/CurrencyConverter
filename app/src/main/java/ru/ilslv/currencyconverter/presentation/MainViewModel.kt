package ru.ilslv.currencyconverter.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ru.ilslv.currencyconverter.domain.base.Failure
import ru.ilslv.currencyconverter.domain.usecase.ConvertCurrencyUseCase

class MainViewModel(private val convertCurrencyUseCase: ConvertCurrencyUseCase) : ViewModel() {

    sealed class CurrencyConversionState {
        object Loading : CurrencyConversionState()
        data class Success(val value: Double) : CurrencyConversionState()
    }

    private val currencyConversionStateLiveData = MutableLiveData<CurrencyConversionState>()
    val currencyConversionState: LiveData<CurrencyConversionState>
        get() = currencyConversionStateLiveData

    fun convertValue(fromCurrencyKey: String, toCurrencyKey: String, value: Double) {
        currencyConversionStateLiveData.postValue(CurrencyConversionState.Loading)
        convertCurrencyUseCase.invoke(
            viewModelScope,
            ConvertCurrencyUseCase.ConvertCurrencyParams(fromCurrencyKey, toCurrencyKey, value)
        ) {
            it.fold(::handleError, ::handleSuccess)
        }
    }

    private fun handleSuccess(conversionResult: Double) {
        currencyConversionStateLiveData.postValue(CurrencyConversionState.Success(conversionResult))
    }

    private fun handleError(exception: Failure) {
        //nothing
    }

}