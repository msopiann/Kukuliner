package com.bangkit.kukuliner.di

import android.content.Context
import com.bangkit.kukuliner.data.CulinaryRepository
import com.bangkit.kukuliner.preference.SettingPreferences
import com.bangkit.kukuliner.preference.dataStore

object Injection {
    fun provideRepository(context: Context): CulinaryRepository {
        val pref = SettingPreferences.getInstance(context.dataStore)
        return CulinaryRepository.getInstance(pref)
    }
}