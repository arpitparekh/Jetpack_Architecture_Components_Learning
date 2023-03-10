package com.example.newandroidkotlinmodule.room_database

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ContactViewModelFactory(private val repo: ContactRepo) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ContactViewModel(repo) as T
    }

}