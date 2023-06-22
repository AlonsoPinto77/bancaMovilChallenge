package com.bancamovil.data.repositories.product

import com.bancamovil.data.network.RoomMapper

data class ProductResponse(
    val Title: String,
    val Amount: String
): RoomMapper<ProductEntity> {
    override fun mapToRoomEntity(): ProductEntity {
        return ProductEntity(Title, Amount)
    }
}