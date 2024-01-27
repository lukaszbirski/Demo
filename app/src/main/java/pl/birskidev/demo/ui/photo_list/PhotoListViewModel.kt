package pl.birskidev.demo.ui.photo_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pl.birskidev.demo.repository.PhotoRepository
import javax.inject.Inject

@HiltViewModel
class PhotoListViewModel @Inject constructor(
    private val repository: PhotoRepository
) : ViewModel() {

    init {
        viewModelScope.launch {
            // todo @lukasz needs fixing
            val photos = repository.search(format = "json", tags = "cats", nojsoncallback = 1)
            println("TEST VIEWMODEL ${photos.size}")
            photos.forEach {
                println("TEST VIEWMODEL $it")
            }
        }
    }

    fun getRepo() = repository
}
