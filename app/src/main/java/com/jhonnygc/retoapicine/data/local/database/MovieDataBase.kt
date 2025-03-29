package com.jhonnygc.retoapicine.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jhonnygc.retoapicine.data.local.dao.MovieDao
import com.jhonnygc.retoapicine.data.local.entity.billboardEntity
import com.jhonnygc.retoapicine.data.local.entity.movieEntitiy

@Database(entities = [billboardEntity::class, movieEntitiy::class], version = 2, exportSchema = false)
abstract class MovieDataBase : RoomDatabase(){
companion object{
    private var database: MovieDataBase? = null
    private const val DATABASE_NAME = "Movie_database"
    fun getDatabase(context: Context): MovieDataBase {
        if (database == null) {
            database =
                Room.databaseBuilder(context, MovieDataBase::class.java, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
        }
        return database!!
    }
}

abstract fun MovieDao(): MovieDao

}