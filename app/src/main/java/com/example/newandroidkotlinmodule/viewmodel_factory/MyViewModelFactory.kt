package com.example.newandroidkotlinmodule.viewmodel_factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newandroidkotlinmodule.viewmodel.MyViewModel

class MyViewModelFactory(val counter : Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MyViewModel(counter) as T
    }
}