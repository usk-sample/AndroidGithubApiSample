package com.example.myapplication.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubInterface {

    @GET("/search/repositories")
    fun getSearchRepositories(@Query("q") query: String) : Call<SearchResponse>

}