# Övning 1

Utgå från detta repositories och skapa en lista över alla de filmer som finns i repositories.

    fun bind(movie: Movie) {
        ...

        Glide
           .with(itemView.context)
           .load(movie.posterurl)
           .into(poster)
    }

    Add to manifest:
    <uses-permission android:name="android.permission.INTERNET"/>

# Övning 2

Utgå från detta repositories och skapa en horizontal grid över alla de filmer som finns i repositories.

