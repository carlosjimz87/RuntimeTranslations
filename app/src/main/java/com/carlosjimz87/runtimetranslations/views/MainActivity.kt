package com.carlosjimz87.runtimetranslations.views

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import com.carlosjimz87.runtimetranslations.base.BaseActivity
import com.carlosjimz87.runtimetranslations.databinding.ActivityMainBinding
import com.carlosjimz87.runtimetranslations.receivers.LocaleChangeReceiver
import java.util.Locale

class MainActivity : BaseActivity(){

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    lateinit var localeChangeReceiver: LocaleChangeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setListeners()
        registerLocaleChangeReceiver()
    }

    private fun registerLocaleChangeReceiver() {
        localeChangeReceiver = LocaleChangeReceiver(localeManager)
        val filter = IntentFilter(Intent.ACTION_LOCALE_CHANGED)
        registerReceiver(localeChangeReceiver, filter)
    }

//    override fun onResume() {
//        super.onResume()
//        registerReceivers()
//        localeManager.setLocale(localeManager.getLocale())
//    }

//    private fun registerReceivers() {
//
//        val filter = IntentFilter(Intent.ACTION_LOCALE_CHANGED)
//        registerReceiver(localeChangeReceiver, filter)
//    }

//    override fun onPause() {
//        super.onPause()
//        unregisterReceiver(localeChangeReceiver)
//    }

    private fun setListeners() {

        binding.spanishBT.setOnClickListener {
            localeManager.setLocale(Locale("es"))
            recreate()
        }

        binding.englishBT.setOnClickListener {
            localeManager.setLocale(Locale("en"))
            recreate()
        }

        binding.germanBT.setOnClickListener {
            localeManager.setLocale(Locale("de"))
            recreate()
        }
    }


    override fun onPause() {
        super.onPause()
        unregisterReceiver(localeChangeReceiver)
    }


}