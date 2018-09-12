package com.rakangsoftware.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

import com.rakangsoftware.recyclerview.Movie
import com.rakangsoftware.recyclerview.MovieViewHolder

import java.util.ArrayList

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private var mData: List<Movie> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder.newInstance(parent);
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    fun setData(data: List<Movie>) {
        mData = data
        notifyDataSetChanged()
    }


}