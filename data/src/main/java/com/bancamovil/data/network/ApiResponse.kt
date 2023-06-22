package com.bancamovil.data.network

import com.google.gson.annotations.SerializedName

data class ApiResponse<T>(
    @SerializedName("Success") val success: Boolean,
    @SerializedName("Message") val message: String,
    @SerializedName("Data") var data: T
) {

    override fun toString(): String {
        return ""
    }
}