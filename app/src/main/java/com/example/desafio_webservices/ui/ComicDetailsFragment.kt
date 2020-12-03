package com.example.desafio_webservices.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.example.desafio_webservices.R
import kotlinx.android.synthetic.main.fragment_comic_details.*
import kotlinx.android.synthetic.main.fragment_comic_details.view.*


class ComicDetailsFragment : Fragment() {

    lateinit var contrat:ContractF

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvTitleComic.text = "OQ"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_comic_details, container, false)

        view.toolbarFrag.setNavigationOnClickListener {
            contrat.removeFrag()
        }

        return view
    }


    override  fun  onAttach ( context : Context) {
        super .onAttach (context)
        if (context is ContractF) contrat = context
    }

    companion object {

        fun newInstance() = ComicDetailsFragment()
    }
}