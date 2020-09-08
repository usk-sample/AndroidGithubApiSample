package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainBinding
import timber.log.Timber
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity(), TextWatcher {

    private lateinit var viewModel: MyViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ArrayAdapter<String>
    private var texts: MutableList<String> = mutableListOf()

    private var timer: Timer = Timer()
    private val delay: Long = 500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.plant(Timber.DebugTree())

        viewModel = MyViewModel(application)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.editText.addTextChangedListener(this)

        viewModel.searchResult.observeForever { result ->
            result.onSuccess { response ->
                Timber.e(response.toString())
                this.adapter.clear()
                this.adapter.addAll(response.items.map { it.fullName })
                this.adapter.notifyDataSetChanged()
            }
            result.onFailure {
                Timber.e(it.toString())
            }
        }

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, texts)
        binding.listView.adapter = adapter

    }

    /// 検索を行う
    private fun doSearch(text: String) {
        Timber.e("doSearch:%s", text)
        viewModel.searchRepository(text)
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        //NOP
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        val text = binding.editText.text.toString()

        //タイピングが終わったら検索
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