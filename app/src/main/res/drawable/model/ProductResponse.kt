package com.route.domain.model

data class ProductResponse(
	val total: Int? = null,
	val limit: Int? = null,
	val skip: Int? = null,
	val products: List<ProductsItem?>? = null
)

data class ReviewsItem(
	val date: String? = null,
	val reviewerName: String? = null,
	val reviewerEmail: String? = null,
	val rating: Int? = null,
	val comment: String? = null
)

data class ProductsItem(
	val images: List<String?>? = null,
	val thumbnail: String? = null,
	val minimumOrderQuantity: Int? = null,
	val rating: Any? = null,
	val returnPolicy: String? = null,
	val description: String? = null,
	val weight: Int? = null,
	val warrantyInformation: String? = null,
	val title: String? = null,
	val tags: List<String?>? = null,
	val discountPercentage: Any? = null,
	val reviews: List<ReviewsItem?>? = null,
	val price: Any? = null,
	val meta: Meta? = null,
	val shippingInformation: String? = null,
	val id: Int? = null,
	val availabilityStatus: String? = null,
	val category: String? = null,
	val stock: Int? = null,
	val sku: String? = null,
	val dimensions: Dimensions? = null,
	val brand: String? = null
)

data class Meta(
	val createdAt: String? = null,
	val qrCode: String? = null,
	val barcode: String? = null,
	val updatedAt: String? = null
)

data class Dimensions(
	val depth: Any? = null,
	val width: Any? = null,
	val height: Any? = null
)

