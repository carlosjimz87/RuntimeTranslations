package com.carlosjimz87.runtimetranslations.views

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import com.carlosjimz87.runtimetranslations.Constants.LANGUAGES
import com.carlosjimz87.runtimetranslations.R
import com.carlosjimz87.runtimetranslations.base.BaseActivity
import com.carlosjimz87.runtimetranslations.databinding.ActivityMainBinding
import com.carlosjimz87.runtimetranslations.receivers.LocaleChangeReceiver
import java.util.Locale

class MainActivity : BaseActivity(){

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private lateinit var localeChangeReceiver: LocaleChangeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.app_name_title)
        setListeners()
    }

    private fun registerLocaleChangeReceiver() {
        localeChangeReceiver = LocaleChangeReceiver(localeManager)
        val filter = IntentFilter(Intent.ACTION_LOCALE_CHANGED)
        registerReceiver(localeChangeReceiver, filter)
    }

    private fun setListeners() {

        binding.button.setOnClickListener {
            startActivity(Intent(this, TestActivity1::class.java))
        }
        val localesButtons = mutableListOf(binding.englishBT, binding.spanishBT, binding.germanBT)
        localesButtons.zip(LANGUAGES).forEach { (button, lang) ->
            button.setOnClickListener {
                localeManager.setLocale(Locale(lang))
                recreate()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        registerLocaleChangeReceiver()
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(localeChangeReceiver)
    }


}