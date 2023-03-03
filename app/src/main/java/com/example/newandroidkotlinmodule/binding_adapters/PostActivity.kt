package com.example.newandroidkotlinmodule.binding_adapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newandroidkotlinmodule.databinding.ActivityPostBinding

class PostActivity : AppCompatActivity() {
    lateinit var binding : ActivityPostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post("Cat","Cats are Fun","https://placekitten.com/200/300")
        binding.post = post
    }
}