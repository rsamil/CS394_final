package com.example.myapplication.adapter

import GameDetail
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.Game
import com.example.myapplication.R

class ItemAdapter(private val data: List<Game>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        private lateinit var game: Game

        val titleView: TextView = view.findViewById(R.id.titleView)
        val releaseDateView: TextView = view.findViewById(R.id.releaseDateView)
        val ratingView: TextView = view.findViewById(R.id.ratingView)
        val platformView: TextView = view.findViewById(R.id.platformView)
        val developerView: TextView = view.findViewById(R.id.developerView)
        val genreView: TextView = view.findViewById(R.id.genreView)
        init {
            view.setOnClickListener {
                val context = itemView.context
                val showGameDetailIntent = Intent(context, GameDetail::class.java)
                showGameDetailIntent.putExtra(GameDetail.GAME_TITLE, game.game_title)
                showGameDetailIntent.putExtra(GameDetail.RELEASE_DATE, game.release_date)
                showGameDetailIntent.putExtra(GameDetail.PLATFORM, game.platform)
                showGameDetailIntent.putExtra(GameDetail.GENRE, game.genre)
                showGameDetailIntent.putExtra(GameDetail.DEVELOPER, game.developer)
                showGameDetailIntent.putExtra(GameDetail.RATING, game.rating)
                context.startActivity(showGameDetailIntent)
            }
        }

        fun bind(game: Game) {
            this.game = game
            titleView.text = game.game_title
            releaseDateView.text = game.release_date
            ratingView.text = game.rating
            platformView.text = game.platform
            developerView.text = game.developer
            genreView.text = game.genre

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.game_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int){
        val game = data[position]
        holder.bind(game)
    }



}