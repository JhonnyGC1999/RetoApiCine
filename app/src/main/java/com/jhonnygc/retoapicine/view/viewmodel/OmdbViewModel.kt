package com.jhonnygc.retoapicine.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jhonnygc.retoapicine.data.remote.models.DataMovie
import com.jhonnygc.retoapicine.data.remote.models.DataSearch
import com.jhonnygc.retoapicine.data.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class OmdbViewModel @Inject constructor(val repository: MovieRepository) : ViewModel(){
    val quatModel = MutableLiveData<Array<DataSearch>>()
    val modelQuat = MutableLiveData<DataMovie>()

    fun searchByTitle(title :String ){
        viewModelScope.launch {
            val result = repository.GetMovieTitle(title)
            quatModel.postValue(result)
        }
    }

    fun searchById(id : String){
        viewModelScope.launch {
            val result = repository.GetMovieId(id)
            modelQuat.postValue(result)
        }
    }
}