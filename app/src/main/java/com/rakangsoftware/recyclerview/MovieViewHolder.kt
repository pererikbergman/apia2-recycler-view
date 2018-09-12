package com.rakangsoftware.recyclerview

import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide

class MovieViewHolder(itemView: View, clickListener: OnMovieClicked) : RecyclerView.ViewHolder(itemView) {

    private lateinit var movie: Movie

    private val poster: ImageView
    private val genres: TextView
    private val title: TextView
    private val year: TextView

    init {
        poster = itemView.findViewById(R.id.poster)
        title = itemView.findViewById(R.id.title)
        year = itemView.findViewById(R.id.year)
        genres = itemView.findViewById(R.id.genres)

        itemView.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
               clickListener.onMovieClicked(movie!!)
            }
        })
    }

    fun bind(movie: Movie) {
        this.movie = movie

        title.text = movie.title
        year.text = movie.year
        genres.text = getGenres(movie.genres)

        Glide
                .with(itemView.context)
                .load(movie.posterurl)
                .into(poster)
    }

    private fun getGenres(genres: Array<String>): String {
        return TextUtils.join(", ", genres)
    }

    interface OnMovieClicked {
        fun onMovieClicked(movie: Movie)
    }

    companion object {
        fun newInstance(parent: ViewGroup, clickListener: OnMovieClicked): MovieViewHolder {
            return MovieViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                            R.layout.list_item,
                            parent,
                            false
                    ),
                    clickListener
            )
        }
    }
}