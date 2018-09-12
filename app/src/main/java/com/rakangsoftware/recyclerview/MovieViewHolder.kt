package com.rakangsoftware.recyclerview

import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val mPoster: ImageView
    private val mGenres: TextView
    private val mTitle: TextView
    private val mYear: TextView

    init {

        mPoster = itemView.findViewById(R.id.poster)
        mTitle = itemView.findViewById(R.id.title)
        mYear = itemView.findViewById(R.id.year)
        mGenres = itemView.findViewById(R.id.genres)
    }

    fun bind(model: Movie) {
        mTitle.text = model.title
        mYear.text = model.year
        mGenres.text = getGenres(model.genres)

        Glide
                .with(itemView.context)
                .load(model.posterurl)
                .into(mPoster)
    }

    private fun getGenres(genres: Array<String>): String {
        return TextUtils.join(", ", genres)
    }

    companion object {
        fun newInstance(parent: ViewGroup): MovieViewHolder {
            return MovieViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                            R.layout.list_item,
                            parent,
                            false
                    )
            )
        }
    }
}