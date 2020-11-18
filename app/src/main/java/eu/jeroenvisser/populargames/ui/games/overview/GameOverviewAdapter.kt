package eu.jeroenvisser.populargames.ui.games.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import eu.jeroenvisser.populargames.data.entities.Game
import eu.jeroenvisser.populargames.databinding.GameOverviewListItemBinding

class GameOverviewAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<Game, GameOverviewAdapter.GameViewHolder>(DiffCallback) {

    class GameViewHolder(
        val binding: GameOverviewListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(game: Game) {
            binding.game = game
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Game>() {
        override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        return GameViewHolder(
            GameOverviewListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(game)
        }
        holder.bind(game)
    }

    class OnClickListener(val clickListener: (game : Game) -> Unit) {
        fun onClick(game: Game) = clickListener(game)
    }
}

