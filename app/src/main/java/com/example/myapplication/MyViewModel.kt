package com.example.myapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.api.GithubRepository
import com.example.myapplication.api.GithubRetrofitProvider
import com.example.myapplication.api.SearchResponse

class MyViewModel(application: Application) : AndroidViewModel(application) {

    //検索結果
    var searchResult: MutableLiveData<Result<SearchResponse>> = MutableLiveData()

    private val provider: GithubRetrofitProvider = GithubRetrofitProvider()
    private val repository: GithubRepository = GithubRepository(provider.retrofit)

    fun searchRepository(query: String) {
        repository.searchRepository(query).also { response ->
            if (response.isSuccessful) {
                this.searchResult.postValue(Result.success(response.body()!!))
            } else {
                this.searchResult.postValue(Result.failure(Throwable(response.errorBody()!!.toString())))
            }
        }
    }

}