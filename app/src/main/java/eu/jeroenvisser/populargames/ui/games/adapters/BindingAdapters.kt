package eu.jeroenvisser.populargames.ui.games.adapters

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import eu.jeroenvisser.populargames.R
import eu.jeroenvisser.populargames.data.entities.Game
import eu.jeroenvisser.populargames.ui.games.overview.GameOverviewAdapter

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imageUrl: String?) {
    imageUrl?.let {
        val imgUri = imageUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imageView.context)
            .load(imgUri)
            .apply(RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background))
            .into(imageView)
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Game>?) {
    val adapter = recyclerView.adapter as GameOverviewAdapter
    adapter.submitList(data)
}