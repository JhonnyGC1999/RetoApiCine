package com.jhonnygc.retoapicine.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.jhonnygc.retoapicine.data.remote.models.DataMovie
import com.jhonnygc.retoapicine.data.remote.models.DataSearch
import com.jhonnygc.retoapicine.databinding.FragmentActivityBinding
import com.jhonnygc.retoapicine.view.movielist.adapter.MovieAdapter
import com.jhonnygc.retoapicine.view.viewmodel.OmdbViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActivityFragment : Fragment(), SearchView.OnQueryTextListener,
    android.widget.SearchView.OnQueryTextListener {

    private var _binding: FragmentActivityBinding? = null
    private val binding get() = _binding!!

    private val viewmodel: OmdbViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.svSearch.setOnQueryTextListener(this)
        viewmodel.quatModel.observe(viewLifecycleOwner) {
            initRecyclerView(it.toList())
            if (it.isEmpty()) {
                val query = binding.svSearch.query.toString()
                Toast.makeText(
                    requireContext(),
                    "lo sentimos, no pudimos encontrar $query que ingreso el usuario, verifica los datos ingresados.".toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentActivityBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun initRecyclerView(movie: List<DataSearch>) {
        val adapter = MovieAdapter()
        val layoutManager = GridLayoutManager(requireContext(), 1)
        binding.rvMovie.adapter = adapter
        binding.rvMovie.layoutManager = layoutManager
        adapter.setMovieList(movie)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query.isNullOrEmpty()) {
            viewmodel.searchByTitle(query)
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}