package com.rakangsoftware.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

import java.util.ArrayList

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private var movies: List<Movie> = ArrayList()

    private var mOnMovieClicked: MovieViewHolder.OnMovieClicked? = null

    fun setOnMovieClicked(onMovieClicked: MovieViewHolder.OnMovieClicked) {
        mOnMovieClicked = onMovieClicked;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder.newInstance(parent, mOnMovieClicked!!);
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun setData(movies: List<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }
}