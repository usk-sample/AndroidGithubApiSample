package com.example.myapplication.api

import com.squareup.moshi.Json

/// 検索結果レスポンス
data class SearchResponse(
    val items: List<SearchItem>
)

data class SearchItem(
    val id: Int,
    @Json(name = "full_name") val fullName: String
)