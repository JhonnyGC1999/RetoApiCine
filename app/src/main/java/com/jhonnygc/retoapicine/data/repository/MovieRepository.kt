package com.jhonnygc.retoapicine.data.repository

import android.util.Log
import com.jhonnygc.retoapicine.data.local.dao.MovieDao
import com.jhonnygc.retoapicine.data.local.entity.billboardEntity
import com.jhonnygc.retoapicine.data.local.entity.movieEntitiy
import com.jhonnygc.retoapicine.data.local.entity.toDataMovie
import com.jhonnygc.retoapicine.data.local.entity.toDataSearch
import com.jhonnygc.retoapicine.data.remote.models.DataMovie
import com.jhonnygc.retoapicine.data.remote.models.DataSearch
import com.jhonnygc.retoapicine.data.remote.models.toMovieEntity
import com.jhonnygc.retoapicine.data.remote.models.tobillboardEntity
import com.jhonnygc.retoapicine.data.remote.service.ApiComsume
import com.jhonnygc.retoapicine.view.hasInternetConnection
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val api : ApiComsume,
    private val db: MovieDao
) {

    suspend fun GetMovieTitle(title : String): Array<DataSearch>{
        return if(hasInternetConnection()){
            val movie = api.GetMovieTitle(title)
            inserBillboard(mutableListOf<DataSearch>().apply { addAll(movie) })
            movie
        }else{
            db.GetMovieByTitle(title).map { dataMovie -> dataMovie.toDataSearch() }.toTypedArray()
        }
    }

    suspend fun GetMovieId(id : String) : DataMovie {
        return if(hasInternetConnection()){
            val movie = api.GetMovieId(id) ?: DataMovie.empty()
            inserMovie(movie)
            movie
        } else{
            val movie = db.GetMovieById(id) ?: movieEntitiy.empty()
            movie.toDataMovie()
        }
    }

    fun inserMovie(movie: DataMovie){
        db.insertAll(movie.toMovieEntity())
    }

    fun inserBillboard(movie: List<DataSearch>){
        db.insertAll(movie.map { dataMovie -> dataMovie.tobillboardEntity()})
    }
}