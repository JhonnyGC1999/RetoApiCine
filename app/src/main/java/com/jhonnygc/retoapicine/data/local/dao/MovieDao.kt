package com.jhonnygc.retoapicine.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jhonnygc.retoapicine.data.local.entity.billboardEntity
import com.jhonnygc.retoapicine.data.local.entity.movieEntitiy


@Dao
interface MovieDao {

    @Query("SELECT * FROM billboard_table WHERE title LIKE  '%' || :title || '%'")
    fun GetMovieByTitle(title : String):List<billboardEntity>

    @Query("SELECT * FROM movie_table WHERE imdbID = :id")
    fun GetMovieById(id: String):movieEntitiy

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(billboard: List<billboardEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(movie: movieEntitiy)
}