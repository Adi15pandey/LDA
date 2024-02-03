package com.example.android.lda.api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitI {
    private val BASE_URL = "https://dummyjson.com"

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

   val instance : ApiS = retrofit.create(ApiS::class.java)

}

