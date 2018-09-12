package com.rakangsoftware.recyclerview

import android.content.Context

import com.google.gson.Gson

import java.io.IOException
import java.nio.charset.Charset
import java.util.ArrayList
import java.util.Arrays

class Repository {

    operator fun get(context: Context): List<Movie> {
        val gson = Gson()
        val data = gson.fromJson(loadJSONFromAsset(context), Array<Movie>::class.java)
        return ArrayList(Arrays.asList(*data))
    }

    private fun loadJSONFromAsset(context: Context): String? {
        var json: String? = null
        try {
            val inputStream = context.assets.open("top-rated-movies.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, Charset.defaultCharset())
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }

        return json
    }
}
