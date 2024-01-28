package pl.birskidev.demo.ui.photo_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import pl.birskidev.demo.domain.Photo
import pl.birskidev.demo.usecase.photo_list.GetPhotosUseCase
import javax.inject.Inject

@HiltViewModel
class PhotoListViewModel @Inject constructor(
    getPhotosUseCase: GetPhotosUseCase
) : ViewModel() {

    private val _viewState = MutableLiveData<List<Photo>>()
    val viewState: LiveData<List<Photo>> get() = _viewState

    init {
        // todo @lukasz need fixing
        getPhotosUseCase.invoke(format = "json", tags = "cats", nojsoncallback = 1).onEach { dataState ->
//                _viewState.value = currentViewState().copy(isLoading = dataState.loading)
//
            dataState.data?.let { photos ->
                _viewState.value = photos
            }
//
//                dataState.error?.let { error ->
//                    Log.e(PhotoListViewModel::class.simpleName, "newSearch: $error")
        }.launchIn(viewModelScope)
    }
}
