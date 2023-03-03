package com.example.newandroidkotlinmodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.newandroidkotlinmodule.databinding.ActivityMainBinding
import com.example.newandroidkotlinmodule.lifecycle_observer.MyObserver
import com.example.newandroidkotlinmodule.viewmodel.MyViewModel
import com.example.newandroidkotlinmodule.viewmodel_factory.MyViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var myViewModel : MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycle.addObserver(MyObserver())

        myViewModel = ViewModelProvider(this,MyViewModelFactory(10))[MyViewModel::class.java]

        //make a parameterized viewModel using viewModel factory

        setData()

        binding.btnIncrement.setOnClickListener {
            myViewModel.increment()
            setData()
        }
        binding.btnDecrement.setOnClickListener {
            myViewModel.decrement()
            setData()
        }
    }

    private fun setData() {
        binding.tvCounter.text = myViewModel.counter.toString()
    }
}