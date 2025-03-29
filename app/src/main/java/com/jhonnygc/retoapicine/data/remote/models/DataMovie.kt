package com.jhonnygc.retoapicine.data.remote.models

import com.jhonnygc.retoapicine.data.local.entity.movieEntitiy

data class DataMovie(
    val imdbID : String,
    val Title : String,
    val Released :String,
    val Runtime : String,
    val Genre : String,
    val Director : String,
    val Writer : String,
    val Actors : String,
    val Plot : String,
    val Language : String,
    val Country: String,
    val Poster : String
){
    companion object {
        fun empty() = DataMovie("","","","","","","","","","","","",)
    }

}
fun DataMovie.toMovieEntity() = movieEntitiy(null, imdbID, Title, Released, Runtime, Genre, Director, Writer, Actors, Plot, Language, Country, Poster)
