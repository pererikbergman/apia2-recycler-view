package com.rakangsoftware.recyclerview

import com.google.gson.annotations.SerializedName

data class Movie(
        @SerializedName("title") val title: String,
        @SerializedName("year") val year: String,
        @SerializedName("genres") val genres: Array<String>,
        @SerializedName("posterurl") val posterurl: String
)
