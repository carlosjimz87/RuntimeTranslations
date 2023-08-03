package com.carlosjimz87.runtimetranslations.managers

import android.content.Context
import android.content.SharedPreferences
import android.os.LocaleList
import java.util.Locale

class LocaleManager(private val context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    companion object {
        const val PREF_NAME = "LocalePrefs"
        const val KEY_LANGUAGE = "language"
    }

    fun setLocale(locale: Locale): Context? {
        val configuration = context.resources.configuration
        configuration.setLocale(locale)

        // For Android 7.0 (API 24) and above, use LocaleList
        val localeList = LocaleList(locale)
        LocaleList.setDefault(localeList)
        configuration.setLocales(localeList)

        context.resources.updateConfiguration(configuration, context.resources.displayMetrics)
        saveLocale(locale)
        return context.createConfigurationContext(configuration)
    }

    fun getLocale(): Locale {
        val lang = sharedPreferences.getString(KEY_LANGUAGE, "en")
        return Locale(lang ?: "en")
    }

    private fun saveLocale(locale: Locale) {
        sharedPreferences.edit().putString(KEY_LANGUAGE, locale.language).apply()
    }
}