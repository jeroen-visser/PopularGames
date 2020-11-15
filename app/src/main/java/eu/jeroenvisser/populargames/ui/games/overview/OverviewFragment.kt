package eu.jeroenvisser.populargames.ui.games.overview

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import eu.jeroenvisser.populargames.databinding.GameOverviewFragmentBinding

@AndroidEntryPoint
class OverviewFragment : Fragment(), GameOverviewAdapter.GameItemListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = GameOverviewFragmentBinding.inflate(inflater, container, false)
        val adapter = GameOverviewAdapter(this)

        binding.gameOverviewRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.gameOverviewRecyclerView.adapter = adapter

        val viewModel = ViewModelProvider(this).get(OverviewViewModel::class.java)

        viewModel.games.observe(viewLifecycleOwner, {
            adapter.setItems(ArrayList(it))
        })

        return binding.root
    }

    override fun onClick(gameId: Int) {
        Log.i("OverviewFragment", "onClick")
    }
}