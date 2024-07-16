package com.route.data.model

import androidx.annotation.Keep
import androidx.room.Entity
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.route.data.database.ProductEntity
import com.route.domain.model.ProductsItem
fun <T> Any.convertTo(clazz: Class<T>): T {
    val json = Gson().toJson(this)
    return Gson().fromJson(json, clazz)
}
data class ProductResponseDto(

    @field:SerializedName("total")
    val total: Int? = null,

    @field:SerializedName("limit")
    val limit: Int? = null,

    @field:SerializedName("skip")
    val skip: Int? = null,

    @field:SerializedName("products")
    val products: List<ProductsItemDto?>? = null
)

data class Dimensions(

    @field:SerializedName("depth")
    val depth: Any? = null,

    @field:SerializedName("width")
    val width: Any? = null,

    @field:SerializedName("height")
    val height: Any? = null
)
@Keep

data class ProductsItemDto(

    @field:SerializedName("images")
    val images: List<String?>? = null,

    @field:SerializedName("thumbnail")
    val thumbnail: String? = null,

    @field:SerializedName("minimumOrderQuantity")
    val minimumOrderQuantity: Int? = null,

    @field:SerializedName("rating")
    val rating: Any? = null,

    @field:SerializedName("returnPolicy")
    val returnPolicy: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("weight")
    val weight: Int? = null,

    @field:SerializedName("warrantyInformation")
    val warrantyInformation: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("tags")
    val tags: List<String?>? = null,

    @field:SerializedName("discountPercentage")
    val discountPercentage: Any? = null,

    @field:SerializedName("reviews")
    val reviews: List<ReviewsItem?>? = null,

    @field:SerializedName("price")
    val price: Any? = null,

    @field:SerializedName("meta")
    val meta: Meta? = null,

    @field:SerializedName("shippingInformation")
    val shippingInformation: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("availabilityStatus")
    val availabilityStatus: String? = null,

    @field:SerializedName("category")
    val category: String? = null,

    @field:SerializedName("stock")
    val stock: Int? = null,

    @field:SerializedName("sku")
    val sku: String? = null,

    @field:SerializedName("dimensions")
    val dimensions: Dimensions? = null,

    @field:SerializedName("brand")
    val brand: String? = null
) {
    fun toEntity(): ProductEntity {
        return ProductEntity(
            id = id ?: 0,
            title = title ?: "",
            description = description ?: "",
            price = price as? Double ?: 0.0,
            thumbnail = thumbnail ?: "",
            rating=rating as? Int ?: 0,
            discountPercentage = discountPercentage as? Double ?: 0.0

        )
    }
}

data class ReviewsItem(

    @field:SerializedName("date")
    val date: String? = null,

    @field:SerializedName("reviewerName")
    val reviewerName: String? = null,

    @field:SerializedName("reviewerEmail")
    val reviewerEmail: String? = null,

    @field:SerializedName("rating")
    val rating: Int? = null,

    @field:SerializedName("comment")
    val comment: String? = null
)

data class Meta(

    @field:SerializedName("createdAt")
    val createdAt: String? = null,

    @field:SerializedName("qrCode")
    val qrCode: String? = null,

    @field:SerializedName("barcode")
    val barcode: String? = null,

    @field:SerializedName("updatedAt")
    val updatedAt: String? = null
)
