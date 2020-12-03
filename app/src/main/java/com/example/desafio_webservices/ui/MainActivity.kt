package com.example.desafio_webservices.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.desafio_webservices.R
import com.example.desafio_webservices.entities.Results
import com.example.desafio_webservices.services.service
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ComicAdapter.OnComicClickListener, ContractF {

    val fragDetComic = ComicDetailsFragment.newInstance()
    lateinit var adapterComics:ComicAdapter
    lateinit var gridLayoutManager: GridLayoutManager
    var retornoComics = arrayListOf<Results>()

    val viewModel by viewModels<MainViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(service) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridLayoutManager = GridLayoutManager(this,3)
        rvComics.layoutManager = gridLayoutManager

        viewModel.retorno.observe(this){
            retornoComics.addAll(it.data.results)
            adapterComics = ComicAdapter(retornoComics,this)
            rvComics.adapter = adapterComics
        }

        viewModel.getComicsRepo()
    }

    override fun comicClick(position: Int) {
        viewModel.retorno.observe(this){
            val comic = retornoComics.get(position)
            adapterComics.notifyItemChanged(position)
            supportFragmentManager.beginTransaction().apply{
                add(R.id.flDetails, fragDetComic)
                commit()}
        }

    }

    override fun callImage() {
        TODO("Not yet implemented")
    }

    override fun removeFrag() {
        supportFragmentManager.beginTransaction().apply{
            remove(fragDetComic)
            commit()}
    }


}