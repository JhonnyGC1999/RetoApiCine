package com.jhonnygc.retoapicine.data.remote.service

import com.jhonnygc.retoapicine.data.remote.models.DataMovie
import com.jhonnygc.retoapicine.data.remote.models.DataResultApi
import com.jhonnygc.retoapicine.data.remote.models.DataSearch
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/")
    suspend fun GetMovieTitle(
        @Query("apikey") apiKey: String,
        @Query("s") query: String
    ) : Response<DataResultApi>

    @GET("/")
    suspend fun GetIdMovie(
        @Query("apikey") apiKey: String,
        @Query("i") id:String
    ): Response<DataMovie>

    @GET("/")
    suspend fun GetMovieTitlePage(
        @Query("apikey") apiKey : String,
        @Query("s") title: String,
        @Query("page") page: Int
    ):Response<DataResultApi>

}