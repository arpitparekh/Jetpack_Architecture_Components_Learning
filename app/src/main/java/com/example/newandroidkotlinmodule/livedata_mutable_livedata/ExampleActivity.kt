package com.example.newandroidkotlinmodule.livedata_mutable_livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.newandroidkotlinmodule.databinding.ActivityExampleBinding

class ExampleActivity : AppCompatActivity() {
    lateinit var binding : ActivityExampleBinding
    lateinit var exampleViewModel: ExampleViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        exampleViewModel = ViewModelProvider(this)[ExampleViewModel::class.java]

        binding.exampleViewModel = exampleViewModel   // viewModel binding

        binding.lifecycleOwner = this

//        exampleViewModel.factsLiveData.observe(this, Observer {
//            binding.textView.text = it
//        })
    }
}