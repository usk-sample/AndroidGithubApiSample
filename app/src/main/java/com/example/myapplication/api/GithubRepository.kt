package com.example.myapplication.api

import retrofit2.Response
import retrofit2.Retrofit

class GithubRepository(private val retrofit: Retrofit) {

    fun searchRepository() : Response<SearchResponse> {
        val service = retrofit.create(GithubInterface::class.java)
        return service.getSearchRepositories().execute()
    }

}