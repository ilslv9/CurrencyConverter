package ru.ilslv.currencyconverter.domain.usecase

import ru.ilslv.currencyconverter.domain.base.Either
import ru.ilslv.currencyconverter.domain.base.Failure
import ru.ilslv.currencyconverter.domain.repository.CurrencyRepository
import ru.ilslv.currencyconverter.domain.usecase.base.BaseUseCase

class ConvertCurrencyUseCase(private val currencyRepository: CurrencyRepository) :
    BaseUseCase<Double, ConvertCurrencyUseCase.ConvertCurrencyParams>() {

    data class ConvertCurrencyParams(
        val baseCurrencyKey: String,
        val convertedCurrencyKey: String,
        val currencyValue: Double
    )

    override suspend fun run(params: ConvertCurrencyParams): Either<Failure, Double> {
        return try {
            val response = currencyRepository.loadCurrencyRates(params.baseCurrencyKey)
            val rates =
                response
                    ?: throw IllegalStateException("Currency not found")
            val course = rates.rates[params.convertedCurrencyKey]
                ?: throw IllegalStateException("Course not found")
            Either.Right(course * params.currencyValue)
        } catch (exc: Exception) {
            Either.Left(Failure.ConvertCurrencyFailure(exc))
        }
    }

}