package com.example.android.lda.Model

data class ProductapiResponse(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)
