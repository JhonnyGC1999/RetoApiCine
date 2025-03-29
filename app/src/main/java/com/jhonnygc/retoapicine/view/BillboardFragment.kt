package com.jhonnygc.retoapicine.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.jhonnygc.retoapicine.R
import com.jhonnygc.retoapicine.data.remote.models.DataMovie
import com.jhonnygc.retoapicine.databinding.FragmentBillboardBinding
import com.jhonnygc.retoapicine.view.movielist.adapter.MovieViewHolder
import com.jhonnygc.retoapicine.view.viewmodel.OmdbViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BillboardFragment : Fragment() {

    private var _binding : FragmentBillboardBinding? = null
    private val binding get() = _binding!!

    private val viewModel : OmdbViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val moviId = arguments?.getString("MoveId")
        if (moviId != null) {
            viewModel.searchById(moviId)
            viewModel.modelQuat.observe(viewLifecycleOwner) {
                render(it)
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBillboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun render(movie: DataMovie) {
        Glide
            .with(binding.root.context)
            .load(movie.Poster)
            .into(binding.ivPhoto)

        binding.tvTitle.text = movie.Title
        binding.tvReleased.text = movie.Released
        binding.tvRuntime.text = movie.Runtime
        binding.tvGenre.text = movie.Genre
        binding.tvDirector.text = movie.Director
        binding.tvWriter.text = movie.Writer
        binding.tvActors.text = movie.Plot
        binding.tvLanguaje.text = movie.Language
        binding.tvCountry.text = movie.Country

    }

}