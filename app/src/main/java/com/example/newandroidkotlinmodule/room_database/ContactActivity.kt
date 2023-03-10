package com.example.newandroidkotlinmodule.room_database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.newandroidkotlinmodule.databinding.ActivityContactBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList

class ContactActivity : AppCompatActivity() {

    lateinit var binding : ActivityContactBinding
    lateinit var list : ArrayList<Contact>
    lateinit var adapter : ArrayAdapter<Contact>
    lateinit var contactViewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = ArrayList()
        adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
        binding.listView.adapter = adapter

        val dao = ContactDatabase.getDatabase(this).getContactDao()
        val repo = ContactRepo(dao)
        contactViewModel = ViewModelProvider(this,ContactViewModelFactory(repo))[ContactViewModel::class.java]

        GlobalScope.launch {
            contactViewModel.insertContact(Contact("Arpit","1212", Date(),1))
        }

        contactViewModel.getQuotes().observe(this){
            list = it as ArrayList<Contact>
            adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
            binding.listView.adapter = adapter
        }
    }
}