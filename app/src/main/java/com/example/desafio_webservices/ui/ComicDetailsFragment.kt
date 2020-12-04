package com.example.desafio_webservices.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.desafio_webservices.R
import com.example.desafio_webservices.entities.Results
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_comic_details.*
import kotlinx.android.synthetic.main.fragment_comic_details.view.*



class ComicDetailsFragment : Fragment() {

    lateinit var contrat: ContractF
    lateinit var imgBig:String

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_comic_details, container, false)

        view.toolbarFrag.setNavigationOnClickListener {
            Log.i("TAG", "SETA BACK")
            contrat.removeFrag()

        }

        val comic = requireArguments().getSerializable("comic") as Results

        var imgSma = comic.images[0].path + "." + comic.images[0].extension


        if (comic.images.size > 1){
            imgBig = comic.images[1].path + "." + comic.images[1].extension
        }
        else {
            imgBig = imgSma
        }


        view.tvTitleComic.text = comic.title.toUpperCase()
        view.tvDescComic.text = comic.description
        view.tvDatePubliComic.text = comic.dates[0].date.split("T")[0]
        view.tvValuePriceComic.text = "$ " + comic.prices[0].price.toString()
        view.tvQtdPagesComic.text = comic.pageCount.toString()

        Picasso.get().load(imgSma).resize(110,150).into(view.ivComic1)
        Picasso.get().load(imgBig).resize(415,250).into(view.ivComic2)

        view.ivComic1.setOnClickListener {
            contrat.callImage(imgSma)
        }


        return view
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ContractF) contrat = context
    }

    companion object {
        fun newInstance() = ComicDetailsFragment()

    }

}