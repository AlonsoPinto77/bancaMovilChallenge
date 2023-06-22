package com.bancamovil.data.utils

import android.content.Context
import android.preference.PreferenceManager

object PrefUtils {
    fun setStringPreference(context: Context, key: String, value: String) {
        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = pref.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getStringPreference(context: Context, key: String, defaultValue: String = ""): String? {
        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        return try {
            pref.getString(key, defaultValue)
        } catch (e: Exception) {
            e.printStackTrace()
            defaultValue
        }
    }

    fun setIntPreference(context: Context, key: String, value: Int) {
        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = pref.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    fun getIntPreference(context: Context, key: String, defaultValue: Int = 0): Int? {
        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        return try {
            pref.getInt(key, defaultValue)
        } catch (e: Exception) {
            e.printStackTrace()
            defaultValue
        }
    }
}