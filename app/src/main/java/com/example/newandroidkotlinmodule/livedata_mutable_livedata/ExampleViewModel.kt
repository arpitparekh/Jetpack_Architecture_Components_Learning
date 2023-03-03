package com.example.newandroidkotlinmodule.livedata_mutable_livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExampleViewModel : ViewModel() {

    var factsLiveDataObject = MutableLiveData<String>("This is a Fact")


    fun changeFacts(){
        factsLiveDataObject.value = "This is Updated Fact"
    }
}