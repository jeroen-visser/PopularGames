package eu.jeroenvisser.populargames.ui.games.overview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import eu.jeroenvisser.populargames.R
import eu.jeroenvisser.populargames.data.entities.Game
import eu.jeroenvisser.populargames.databinding.GameOverviewListItemBinding

class GameOverviewAdapter(
    private val listener: GameItemListener
) : RecyclerView.Adapter<GameViewHolder>() {

    interface GameItemListener {
        fun onClick(gameId: Int)
    }

    private val items = ArrayList<Game>()

    fun setItems(items: ArrayList<Game>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val binding = GameOverviewListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return GameViewHolder(binding, listener)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(
        holder: GameViewHolder,
        position: Int
    ) = holder.bind(items[position])
}

class GameViewHolder(
    private val binding: GameOverviewListItemBinding,
    private val listener: GameOverviewAdapter.GameItemListener
) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

    private lateinit var game: Game

    init {
        binding.root.setOnClickListener(this)
    }

    fun bind(game: Game) {
        this.game = game
        binding.gameTitle.text = game.title

        val requestOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        Glide.with(binding.root)
            .applyDefaultRequestOptions(requestOptions)
            .load(game.cover.url)
            .into(binding.image)
    }

    override fun onClick(v: View?) {
        listener.onClick(gameId = game.id)
    }
}
