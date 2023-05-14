package com.pucuk.latihan_newsapi.network

import com.pucuk.latihan_newsapi.model.Source
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("top-headlines/sources")
    fun getAllSources(
        @Query("category") category : String,
        @Query("apikey") apikey : String = "8077ec12a9ad48139fbeb43c81b1f40e"
    ) : Call<List<Source>>
}