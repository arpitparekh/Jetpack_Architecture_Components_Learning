package com.example.newandroidkotlinmodule.viewmodel

import androidx.lifecycle.ViewModel

class MyViewModel(val initValue : Int) : ViewModel() {

    var counter : Int = initValue

    fun increment(){
        counter++
    }
    fun decrement(){
        counter--
    }

}