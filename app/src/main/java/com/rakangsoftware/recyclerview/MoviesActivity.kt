package com.rakangsoftware.recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView


class MoviesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        // Get a reference to the RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.movie_list)
        recyclerView.setHasFixedSize(true)

        // Set the layout manager
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.setLayoutManager(layoutManager)

        // Set the adapter
        val movies = Repository().get(this)

        val adapter = MovieAdapter()
        adapter.setData(movies)
        recyclerView.setAdapter(adapter)
    }
}
