package com.example.newandroidkotlinmodule.quotify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.newandroidkotlinmodule.databinding.ActivityQuoteBinding

class QuoteActivity : AppCompatActivity() {
    lateinit var binding : ActivityQuoteBinding
    lateinit var quoteViewModel: QuoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel = ViewModelProvider(this,QuoteViewModelFactory(application))[QuoteViewModel::class.java]

        setQuotes(quoteViewModel.getQuote())

        binding.ivNext.setOnClickListener {
            onNext()
        }
        binding.ivPrevious.setOnClickListener {
            onPrevious()
        }
        binding.fabShare.setOnClickListener {
            onShare()
        }

    }
    fun setQuotes(quote: Quote){
         binding.tvQuotes.text = "${quote.text}\n\n${quote.author}"
    }

    fun onPrevious(){
        return setQuotes(quoteViewModel.previousQuote())
    }
    fun onNext(){
        return setQuotes(quoteViewModel.nextQuote())
    }
    fun onShare(){
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT,quoteViewModel.getQuote().text)
        startActivity(intent)
    }
}