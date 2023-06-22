package com.bancamovil.data.repositories.product

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bancamovil.data.network.DomainMapper
import com.bancamovil.domain.interactors.product.Product
import com.google.gson.annotations.SerializedName

@Entity(tableName = "product")
data class ProductEntity(
    @PrimaryKey
    @NonNull
    @SerializedName("Title")
    val title: String,
    @SerializedName("Amount")
    val amount: String
) : DomainMapper<Product> {
    override fun mapToDomainModel(): Product {
        return Product(title, amount)
    }
}