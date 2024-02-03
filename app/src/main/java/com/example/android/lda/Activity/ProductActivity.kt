package com.example.android.lda.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.lda.Model.Product
import com.example.android.lda.Model.ProductapiResponse
import com.example.android.lda.R
import com.example.android.lda.adapter.ProductAdapter
import com.example.android.lda.api.RetrofitI
import com.example.android.lda.api.RetrofitI.instance
import okhttp3.internal.Internal.instance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class ProductActivity : AppCompatActivity() {
    private lateinit var recView: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        recView = findViewById(R.id.recView)
        progressBar = findViewById(R.id.progressBar)
        progressBar.visibility = View.VISIBLE
        var products : ArrayList<Product> = arrayListOf()
        val productAdapter = ProductAdapter(this, products)
        recView.adapter = productAdapter
        recView.layoutManager = LinearLayoutManager(this)
         val retrofitInstance = RetrofitI.instance
        retrofitInstance.getProducts().enqueue(object : Callback<ProductapiResponse> {
            override fun onResponse(
                call: Call<ProductapiResponse>,
                response: Response<ProductapiResponse>
            ) {
                val items = response.body()!!.products
                for (product in items)
                   products.add(product)
             productAdapter.notifyDataSetChanged()
                progressBar.visibility = View.INVISIBLE
            }

            override fun onFailure(call: Call<ProductapiResponse>, t: Throwable) {
                progressBar.visibility = View.INVISIBLE
            }
        })
    }
}
