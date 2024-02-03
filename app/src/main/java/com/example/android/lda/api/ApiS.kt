package com.example.android.lda.api

import com.example.android.lda.Model.ProductapiResponse
import retrofit2.http.GET
import retrofit2.Call

interface ApiS {
    @GET("/products")
    fun getProducts(): Call<ProductapiResponse>
}