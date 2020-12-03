package com.example.desafio_webservices.ui



import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafio_webservices.entities.Res
import com.example.desafio_webservices.services.Service
import kotlinx.coroutines.launch

class MainViewModel(val service: Service):ViewModel() {
//    var listComics = MutableLiveData<ArrayList<Results>>()
   var retorno = MutableLiveData<Res>()
//    var listComics = MutableLiveData<List<Results>>()

    fun getComicsRepo(){
        viewModelScope.launch {
            retorno.value = service.getComicsRepo(
                    1,
                    10,
                    "1",
                    "19cec655f0cd0b638d1b984a4cb483ad",
                    "04368b032ac462986231cdfed6c78a56"
            )
            Log.i("TAG", retorno.value.toString())
        }

    }
}