package ru.ilslv.currencyconverter.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel
import ru.ilslv.currencyconverter.R

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.convertValue("USD", "RUB", 1000.0)
        viewModel.currencyConversionState.observe(this, Observer {
            when (it) {
                is MainViewModel.CurrencyConversionState.Loading -> {

                }
                is MainViewModel.CurrencyConversionState.Success -> {
                    result.text = it.value.toString()
                }
            }
        })
    }
}
