package com.jhonnygc.retoapicine.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jhonnygc.retoapicine.data.remote.models.DataSearch

@Entity(tableName = "billboard_table")
data class billboardEntity(
    @PrimaryKey (autoGenerate = true)val id : Int? = null,
    val Title : String,
    val Year: String,
    val imdbID: String,
    val Type: String,
    val Poster : String
)

fun billboardEntity.toDataSearch() = DataSearch(this.Title, this.Year, this.imdbID, this.Type, this.Poster)
