package com.example.myapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.api.GithubRepository
import com.example.myapplication.api.GithubRetrofitProvider
import com.example.myapplication.api.SearchResponse

class MyViewModel(application: Application) : AndroidViewModel(application) {

    //検索結果
    private var _searchResult: MutableLiveData<Result<SearchResponse>> = MutableLiveData()
    val searchResult: LiveData<Result<SearchResponse>> get() = _searchResult

    //API
    private val provider: GithubRetrofitProvider = GithubRetrofitProvider()
    private val repository: GithubRepository = GithubRepository(provider.retrofit)

    //リポジトリを検索
    fun searchRepository(query: String) {
        repository.searchRepository(query).also { response ->
            if (response.isSuccessful) {
                this._searchResult.postValue(Result.success(response.body()!!))
            } else {
                this._searchResult.postValue(Result.failure(Throwable(response.errorBody()!!.toString())))
            }
        }
    }

}