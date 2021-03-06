package ru.ilslv.currencyconverter.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object HashMapTypeConverter {

    @TypeConverter
    @JvmStatic
    fun stringToMap(value: String): Map<String, Double> {
        return Gson().fromJson(value, object : TypeToken<HashMap<String, Double>>() {}.type)
    }

    @TypeConverter
    @JvmStatic
    fun mapToString(value: Map<String, Double>): String {
        return Gson().toJson(value)
    }
}