package com.bancamovil.data.utils

import android.content.Context
import android.net.ConnectivityManager

interface NetworkUtils {
    fun hasNetworkAccess(): Boolean
}

class NetworkUtilsImpl(private val context: Context) : NetworkUtils {
    override fun hasNetworkAccess(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = connectivityManager.activeNetworkInfo
        return info != null && info.isConnected
    }
}