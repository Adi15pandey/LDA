package com.example.android.lda.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.denzcoskun.imageslider.models.SlideModel
import com.example.android.lda.Model.Product
import com.example.android.lda.R
import com.example.android.lda.databinding.ActivityDescriptionBinding
import java.io.Serializable

class DescriptionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDescriptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(intent.hasExtra("product")){
            val product : Serializable? = intent.getSerializableExtra("product") as Product
            product as Product
            binding.apply{

                title.text = product.title
                originalPrice.text = product.price.toString()
                price.text = Math.round(product.price*(100-product.discountPercentage)/100.0).toString()
                discount.text = product.discountPercentage.toString()
                stock.text = product.stock.toString()
                rating.text = product.rating.toString()
                brand.text = product.brand
                description.text = product.description
                category.text = category.text

                val images = arrayListOf<SlideModel>()
                for(url in product.images)
                    images.add(SlideModel(url))
                imageSlider.setImageList(images)
            }
        }
    }
}