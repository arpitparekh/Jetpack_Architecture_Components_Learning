package com.example.newandroidkotlinmodule.binding_adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageFromUrl")
fun ImageView.loadImage(url  :String){
    Glide.with(this.context).load(url).into(this)
}