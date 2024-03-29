package pl.birskidev.demo.ui.photo_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import pl.birskidev.demo.databinding.FragmentPhotoListBinding

@AndroidEntryPoint
class PhotoListFragment : Fragment() {

    private lateinit var binding: FragmentPhotoListBinding

    private val viewModel: PhotoListViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPhotoListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = PhotosAdapter()
        val gridLayoutManager = GridLayoutManager(requireContext(), viewModel.getSpanCount())
        binding.fragmentPhotoPhotosAdapter.apply {
            this.adapter = adapter
            this.layoutManager = gridLayoutManager
        }
        viewModel.screenState.onEach {
            adapter.submitList(it.items)
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }
}
