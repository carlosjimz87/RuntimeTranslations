package com.carlosjimz87.runtimetranslations.base

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.carlosjimz87.runtimetranslations.managers.LocaleManager
import com.carlosjimz87.runtimetranslations.receivers.LocaleChangeReceiver

open class BaseActivity : AppCompatActivity() {

    lateinit var localeManager: LocaleManager

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        localeManager.setLocale(localeManager.getLocale())
    }

    override fun attachBaseContext(base: Context) {
        localeManager = LocaleManager(base)
        val newLocale = localeManager.getLocale()
        val context = localeManager.setLocale(newLocale)
        super.attachBaseContext(context)
    }

}