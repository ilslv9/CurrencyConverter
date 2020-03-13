package ru.ilslv.currencyconverter.data.repository

import ru.ilslv.currencyconverter.data.NetworkHandler
import ru.ilslv.currencyconverter.data.db.CurrencyRatesDao
import ru.ilslv.currencyconverter.data.db.entity.CurrencyRateEntity
import ru.ilslv.currencyconverter.data.db.entity.mapToDomainModel
import ru.ilslv.currencyconverter.data.remote.ServerApi
import ru.ilslv.currencyconverter.data.remote.model.mapToDomainModel
import ru.ilslv.currencyconverter.domain.model.CurrencyRatesModel
import ru.ilslv.currencyconverter.domain.repository.CurrencyRepository

class CurrencyRepositoryImpl(
    private val networkHandler: NetworkHandler,
    private val serverApi: ServerApi,
    private val dao: CurrencyRatesDao
) : CurrencyRepository {

    override suspend fun loadCurrencyRates(baseCurrencyKey: String): CurrencyRatesModel? {
        return when (networkHandler.isConnected) {
            true -> {
                val rates =
                    serverApi.loadCurrencyRatesAsync(baseCurrencyKey).await().mapToDomainModel()
                    dao.insertCurrencyRate(
                        CurrencyRateEntity(
                            rates.baseCurrency,
                            rates.date,
                            rates.rates
                        )
                    )
                rates
            }
            false -> dao.findByBaseCurrency(baseCurrencyKey)?.mapToDomainModel()
        }
    }
}