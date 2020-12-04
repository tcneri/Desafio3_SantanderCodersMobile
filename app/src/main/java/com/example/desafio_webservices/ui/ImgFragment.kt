package com.example.desafio_webservices.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.desafio_webservices.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_comic_details.view.*
import kotlinx.android.synthetic.main.fragment_img.*
import kotlinx.android.synthetic.main.fragment_img.view.*


class ImgFragment : Fragment() {

    lateinit var contr:ContractF

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_img, container, false)

        view.toolbarImg.setNavigationOnClickListener(){
            contr.removeFrag()
        }

       var img = requireArguments().getString("img")

        Picasso.get().load(img).resize(370,570).into(view.ivImgComic)

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ContractF) contr = context
    }

    companion object {
        fun newInstance() = ImgFragment()
    }
}