package com.example.myapplication.api

import retrofit2.Call
import retrofit2.http.GET

interface GithubInterface {

    @GET("/search/repositories")
    fun getSearchRepositories() : Call<SearchResponse>
    
}