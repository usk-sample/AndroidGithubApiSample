package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainBinding
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity(), TextWatcher {

    private lateinit var viewModel: MyViewModel
    private lateinit var binding: ActivityMainBinding

    private var timer: Timer = Timer()
    private val delay: Long = 500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = MyViewModel(application)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.editText.addTextChangedListener(this)

    }

    private fun doSearch(text: String) {

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        //NOP
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        val text = binding.editText.text.toString()

        timer.cancel()
        timer = Timer()
        timer.schedule(delay) {
            this@MainActivity.doSearch(text)
        }
    }

    override fun afterTextChanged(s: Editable?) {
        //NOP
    }
}