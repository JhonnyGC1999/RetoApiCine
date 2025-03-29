package com.jhonnygc.retoapicine.view.movielist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jhonnygc.retoapicine.R
import com.jhonnygc.retoapicine.data.remote.models.DataMovie
import com.jhonnygc.retoapicine.data.remote.models.DataSearch
import com.jhonnygc.retoapicine.databinding.ItemBillboardBinding

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private var movieList:List<DataSearch> = emptyList()

    fun setMovieList(movie:List<DataSearch>){
        movieList = movie
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_billboard, parent, false)
        val binding = ItemBillboardBinding.bind(view)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.render(movie)
    }
}