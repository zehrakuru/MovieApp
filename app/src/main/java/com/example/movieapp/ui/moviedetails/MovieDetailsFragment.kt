package com.example.movieapp.ui.moviedetails

import android.os.Bundle
import android.view.View
import com.example.movieapp.base.BaseFragment
import com.example.movieapp.databinding.MovieListDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment :
    BaseFragment<MovieListDetailsBinding>(MovieListDetailsBinding::inflate) {
    override fun setupUI(savedInstanceState: Bundle?) {
    }

    override fun onClick(p0: View?) {
    }
}