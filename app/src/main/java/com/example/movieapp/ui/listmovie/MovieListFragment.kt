package com.example.movieapp.ui.listmovie

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.movieapp.base.BaseFragment
import com.example.movieapp.data.web.model.MovieListResponse
import com.example.movieapp.databinding.FragmentMovieListBinding
import com.example.movieapp.domain.usecase.UseCaseState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieListFragment :
    BaseFragment<FragmentMovieListBinding>(FragmentMovieListBinding::inflate) {

    private val viewModel: MovieListViewModel by viewModels()

    private fun setupAdapter() {
        binding.onBoardCardView.adapter = movieListAdapter
        movieListAdapter.setOnItemClickListener {
            val navigation = MovieListFragmentDirections.actionMovieListFragmentToMovieDetailsFragment()
            findNavController().navigate(navigation)
        }
    }

    private val movieListAdapter by lazy {
        MovieListFragmentAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupAdapter()
        viewModel.listLiveData.observe(this) {
            handleMovieList(it)
        }
        viewModel.getMovieListUseCaseState()
    }


    private fun handleMovieList(status: UseCaseState<MovieListResponse>) {
        when (status) {
            is UseCaseState.Error -> {
                // close the loading view
            }
            is UseCaseState.Success -> {
                movieListAdapter.differ.submitList(status?.data?.results)
            }
            else -> {
                // close the loading view
            }
        }
    }
}