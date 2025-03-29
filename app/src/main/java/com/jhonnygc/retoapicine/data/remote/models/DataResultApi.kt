package com.jhonnygc.retoapicine.data.remote.models

data class DataResultApi(
    val Search : Array<DataSearch>,
    val totalResults : Int,
    val Response : Boolean
)