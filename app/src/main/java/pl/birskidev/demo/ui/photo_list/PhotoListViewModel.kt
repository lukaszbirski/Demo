package pl.birskidev.demo.ui.photo_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pl.birskidev.demo.domain.Photo
import pl.birskidev.demo.repository.PhotoRepository
import javax.inject.Inject

@HiltViewModel
class PhotoListViewModel @Inject constructor(
    private val repository: PhotoRepository
) : ViewModel() {

    private val _viewState = MutableLiveData<List<Photo>>()
    val viewState: LiveData<List<Photo>> get() = _viewState

    init {
        viewModelScope.launch {
            val photos = repository.search(format = "json", tags = "cats", nojsoncallback = 1)
            _viewState.value = photos
        }
    }
}
