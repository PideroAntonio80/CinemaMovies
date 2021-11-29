package com.example.cinemamovies

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cinemamovies.databinding.OneMovieBinding

class MovieAdapter(private val movies : List<Movie>,
                   private val context: Context,
                   private val itemClickListener: SeeMovieDetailClickListener?
                   ) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.one_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = movies.size

    inner class ViewHolder(view : View): RecyclerView.ViewHolder(view) {
        private val binding = OneMovieBinding.bind(view)

        fun bind(movie: Movie) {
            binding.tvTitle.text = movie.title
            Glide.with(binding.ivPicture.context).load(movie.picture).into(binding.ivPicture)
            itemView.setOnClickListener {
                itemClickListener?.onItemClick(movie)
            }
        }
    }

    interface SeeMovieDetailClickListener {
        fun onItemClick(item: Movie)
    }
}