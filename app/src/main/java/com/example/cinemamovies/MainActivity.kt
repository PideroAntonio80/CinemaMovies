package com.example.cinemamovies

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cinemamovies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MovieAdapter.SeeMovieDetailClickListener {

    private lateinit var binding: ActivityMainBinding
    private var listener: MovieAdapter.SeeMovieDetailClickListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val layoutManager = GridLayoutManager(this, 3)

        binding.rvRecycler.layoutManager = layoutManager

        binding.rvRecycler.adapter = MovieAdapter(listOf(
            Movie("City of Angels", "https://cdn.icon-icons.com/icons2/304/PNG/512/City_of_Angels_33781.png"),
            Movie("Ice Age", "https://2img.net/h/s26.postimg.cc/j0xnm710p/Ice_Age_El_Gran_Cataclismo.png"),
            Movie("Ninja turtles", "https://2img.net/h/s26.postimg.cc/umcf7nbvt/Tortugas_Ninja_2_Fuera_de_las_sombras.png"),
            Movie("Criminal", "https://2img.net/h/s26.postimg.cc/qobng6zxl/Criminal.png"),
            Movie("Assassins Creed", "https://2img.net/h/s26.postimg.cc/xq9l2e3jd/Assassins_Creed.png"),
            Movie("Life", "https://2img.net/h/s26.postimg.cc/f5py927hl/Life.png"),
            Movie("Logan", "https://2img.net/h/s26.postimg.cc/wx1knimw9/Logan.png"),
            Movie("Divergent", "https://2img.net/h/s26.postimg.cc/8s56gdcyx/La_Serie_Divergente_Leal.png"),
            Movie("Money monster", "https://2img.net/h/s26.postimg.cc/hr4fkvwmh/Money_Monster.png")
        ), this, this)
    }

    override fun onItemClick(item: Movie) {
        val intent = Intent(this, MovieDetailActivity::class.java)
        intent.putExtra("my_movie", item)
        startActivity(intent)
    }
}