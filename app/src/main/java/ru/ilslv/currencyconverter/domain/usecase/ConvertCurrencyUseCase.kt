package ru.ilslv.currencyconverter.domain.usecase

import ru.ilslv.currencyconverter.domain.usecase.base.BaseUseCase
import ru.ilslv.currencyconverter.domain.base.Either
import ru.ilslv.currencyconverter.domain.base.Failure
import ru.ilslv.currencyconverter.domain.repository.CurrencyRepository

class ConvertCurrencyUseCase(private val currencyRepository: CurrencyRepository) :
    BaseUseCase<Double, ConvertCurrencyUseCase.ConvertCurrencyParams>() {

    data class ConvertCurrencyParams(
        val baseCurrencyKey: String,
        val convertedCurrencyKey: String,
        val currencyValue: Double
    )

    override suspend fun run(params: ConvertCurrencyParams): Either<Failure, Double> {
        return try {
            val currencyCourse =
                currencyRepository.loadCurrencyRates(params.baseCurrencyKey).rates[params.convertedCurrencyKey]
                    ?: throw IllegalStateException("Currency not found")
            Either.Right(currencyCourse * params.currencyValue)
        } catch (exc: Exception) {
            Either.Left(Failure.ConvertCurrencyFailure(exc))
        }
    }

}