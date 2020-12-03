package com.example.desafio_webservices.ui


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio_webservices.R
import com.example.desafio_webservices.entities.Results
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_comic.view.*

class ComicAdapter(val listComics: List<Results>, val listener:OnComicClickListener): RecyclerView.Adapter<ComicAdapter.ComicViewHolder>(){


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ComicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comic, parent, false)
        return ComicViewHolder(view)
    }


    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        val comic = listComics.get(position)
        var img = comic.images[0].path + "." + comic.images[0].extension

        holder.tvTit.text = comic.title
        Picasso.get().load(img).into(holder.ivComic)

    }

    override fun getItemCount() = listComics.size

    interface OnComicClickListener{
        fun comicClick(position: Int)
    }




    inner class ComicViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener{
        val tvTit:TextView = view.tvComic
        val ivComic:ImageView = view.ivComic

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (RecyclerView.NO_POSITION != position)
                listener.comicClick(position)
        }
    }


}