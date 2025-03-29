package com.jhonnygc.retoapicine.data.remote.service

import com.jhonnygc.retoapicine.data.remote.models.DataMovie
import com.jhonnygc.retoapicine.data.remote.models.DataSearch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiComsume @Inject constructor(private val api : ApiService) {

    suspend fun GetMovieTitle(title: String): Array<DataSearch> {
        return withContext(Dispatchers.IO) {
            val response = api.GetMovieTitle("f3076ebb", title)
            if (response.isSuccessful) {
                val AllTitleMovie = response.body()
                return@withContext AllTitleMovie?.Search ?: emptyArray<DataSearch>()
            } else {
                return@withContext emptyArray<DataSearch>()
            }
        }
    }

    suspend fun GetMovieId(id: String): DataMovie? {
        return withContext(Dispatchers.IO) {
            val response = api.GetIdMovie("f3076ebb", id)
            if (response.isSuccessful){
                val idMovie = response.body()
                return@withContext idMovie
            }
            else{
                return@withContext null
            }
        }
    }
}