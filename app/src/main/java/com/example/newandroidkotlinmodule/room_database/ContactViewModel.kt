package com.example.newandroidkotlinmodule.room_database

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ContactViewModel(private val repo: ContactRepo) : ViewModel() {

    fun getQuotes() : LiveData<List<Contact>>{
        return repo.getContacts()
    }

    fun insertContact(contact: Contact){
        viewModelScope.launch {
            repo.insertContact(contact)
        }
    }

    fun updateContact(contact: Contact){
        viewModelScope.launch {
            repo.updateContact(contact)
        }
    }

    fun deleteContact(contact: Contact){
        viewModelScope.launch {
            repo.deleteContact(contact)
        }
    }

}