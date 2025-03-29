package com.jhonnygc.retoapicine.data.local.entity
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jhonnygc.retoapicine.data.remote.models.DataMovie

@Entity(tableName = "movie_table")
data class movieEntitiy(
    @PrimaryKey (autoGenerate = true)val id : Int? = null,
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
)
{
    companion object {
        fun empty() = movieEntitiy(null,"","","","","","","","","","","","")
    }
}


fun movieEntitiy.toDataMovie() = DataMovie(this.imdbID, this.Title, this.Released, this.Runtime, this.Genre, this.Director, this.Writer, this.Actors, this.Plot, this.Language, this.Country, this.Poster)

