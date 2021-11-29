package com.example.cinemamovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.cinemamovies.databinding.ActivityMainBinding
import com.example.cinemamovies.databinding.ActivityMovieDetailBinding

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding
    private lateinit var myMovie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showMovie(getMovie())
    }

    private fun getMovie(): Movie {
        val bundle = intent.extras
        if (bundle != null) {
            myMovie = bundle.getSerializable("my_movie") as Movie
        }
        return myMovie
    }

    private fun showMovie(movie: Movie) {
        Glide.with(binding.ivDetailPicture.context).load(movie.picture).into(binding.ivDetailPicture)
        binding.tvDetailTitle.text = movie.title
    }
}