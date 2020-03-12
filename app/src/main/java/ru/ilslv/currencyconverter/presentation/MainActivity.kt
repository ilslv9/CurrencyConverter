package ru.ilslv.currencyconverter.presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel
import ru.ilslv.currencyconverter.R
import ru.ilslv.currencyconverter.domain.model.Currency

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()
    private val adapter: ArrayAdapter<String> by lazy {
        ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_item,
            Currency.values().map { it.name }).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        convert_button.isEnabled = false
        viewModel.currencyConversionState.observe(this, Observer {
            when (it) {
                is MainViewModel.CurrencyConversionState.Loading -> {

                }
                is MainViewModel.CurrencyConversionState.Success -> {
                    result.text = it.value.toString()
                }
            }
        })
        convert_button.setOnClickListener {
            viewModel.convertValue(
                Currency.values()[from_picker.selectedItemPosition].name,
                Currency.values()[to_picker.selectedItemPosition].name,
                value_input.text.toString().toDouble()
            )
        }
    }

    private fun initViews() {
        from_picker.adapter = adapter
        from_picker.setSelection(0)

        to_picker.adapter = adapter
        to_picker.setSelection(0)

        value_input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                convert_button.isEnabled = !s?.trim().isNullOrBlank()
            }
        })
    }
}
