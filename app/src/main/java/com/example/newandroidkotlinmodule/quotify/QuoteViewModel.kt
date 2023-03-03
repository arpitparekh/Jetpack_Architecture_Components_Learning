package com.example.newandroidkotlinmodule.quotify

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class QuoteViewModel(val context: Context) : ViewModel() {
    private var quoteList : Array<Quote> = emptyArray()
    private var index = 0

    init {
        quoteList = loadQuotesFromAsset()
    }

    private fun loadQuotesFromAsset(): Array<Quote> {
        val inputStream = context.assets.open("quotes.json")
        val size : Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer,Charsets.UTF_8)
        val gson = Gson()
        return gson.fromJson(json,Array<Quote>::class.java)
    }

    fun getQuote() : Quote{
        return quoteList[index]
    }
    fun nextQuote() : Quote{
        if(index<quoteList.size-1){
            return quoteList[++index]
        }
        return quoteList[quoteList.size-1]
    }
    fun previousQuote() : Quote{
        if(index>0){
            return quoteList[--index]
        }
        return quoteList[index]
    }

}