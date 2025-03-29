package com.jhonnygc.retoapicine.view.movielist.adapter

import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jhonnygc.retoapicine.databinding.ItemBillboardBinding
import com.jhonnygc.retoapicine.R.id.action_activityFragment_to_billboardFragment
import com.jhonnygc.retoapicine.data.remote.models.DataSearch

class MovieViewHolder(val binding : ItemBillboardBinding): RecyclerView.ViewHolder(binding.root) {

    fun render(movie: DataSearch) {
        Glide
            .with(binding.root.context)
            .load(movie.Poster)
            .centerCrop()
            .into(binding.ivPoster)

        val id = movie.imdbID
        binding.tvTitleMovie.text = movie.Title

        binding.clBillboard.setOnClickListener {
            val bundle = bundleOf("MoveId" to movie.imdbID)

            binding.root.findNavController().navigate(action_activityFragment_to_billboardFragment, bundle)
        }
    }
}