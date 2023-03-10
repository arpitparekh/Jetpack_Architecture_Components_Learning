package com.example.newandroidkotlinmodule.room_database

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Query

class ContactRepo(private val contactDao: ContactDao) {

    fun getContacts() : LiveData<List<Contact>>{
        return contactDao.getAllContact()
    }

    suspend fun updateContact(contact: Contact){
        return contactDao.updateContact(contact)
    }


    suspend fun deleteContact(contact: Contact){
        return contactDao.deleteContact(contact)
    }

    suspend fun  insertContact(contact: Contact){
        return contactDao.insertContact(contact)
    }
}