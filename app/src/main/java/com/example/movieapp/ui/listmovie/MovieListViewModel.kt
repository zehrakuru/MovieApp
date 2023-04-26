package com.example.movieapp.ui.listmovie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.web.model.MovieListResponse
import com.example.movieapp.domain.usecase.GetMovieListUseCase
import com.example.movieapp.domain.usecase.UseCaseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase
) : ViewModel() {

    private val listMutableLiveData = MutableLiveData<UseCaseState<MovieListResponse>>()
    val listLiveData: LiveData<UseCaseState<MovieListResponse>> get() = listMutableLiveData


    fun getMovieListUseCaseState(){
        viewModelScope.launch {
            getMovieListUseCase.invoke().collect{
                when(it){
                    is UseCaseState.Error -> {
                        Log.i(it.message,"")
                    }
                    is UseCaseState.Success->{
                        Log.i(it.message,"")
                        listMutableLiveData.value = it
                    }
                }
            }
        }
    }}