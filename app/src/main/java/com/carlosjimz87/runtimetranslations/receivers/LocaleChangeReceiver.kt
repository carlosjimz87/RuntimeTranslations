package com.carlosjimz87.runtimetranslations.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.carlosjimz87.runtimetranslations.managers.LocaleManager


class LocaleChangeReceiver(private val localeManager: LocaleManager) : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_LOCALE_CHANGED) {
            val newLocale = localeManager.getLocale()
            Log.d("ZZZ", "Locale changed to ${newLocale.language}")
            localeManager.setLocale(newLocale)
        }
    }
}
