package pl.birskidev.demo.ui.photo_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import pl.birskidev.demo.R
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
        val gridLayoutManager = GridLayoutManager(requireContext(), resources.getInteger(R.integer.grid_column_count))
        binding.fragmentPhotoPhotosAdapter.apply {
            this.adapter = adapter
            this.layoutManager = gridLayoutManager
        }
        viewModel.viewState.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }
}
