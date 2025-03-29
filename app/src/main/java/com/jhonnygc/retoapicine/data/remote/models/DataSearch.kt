package com.jhonnygc.retoapicine.data.remote.models

import com.jhonnygc.retoapicine.data.local.entity.billboardEntity

data class DataSearch(
    val Title : String,
    val Year: String,
    val imdbID: String,
    val Type: String,
    val Poster : String
)
fun DataSearch.tobillboardEntity() = billboardEntity(null, Title, Year, imdbID, Type, Poster)
