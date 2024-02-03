package pl.birskidev.demo.ui.photo_list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.window.core.layout.WindowWidthSizeClass
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import pl.birskidev.demo.domain.Photo
import pl.birskidev.demo.usecase.photo_list.GetPhotosUseCase
import pl.birskidev.demo.util.ScreenManager
import javax.inject.Inject

@HiltViewModel
class PhotoListViewModel @Inject constructor(
    private val getPhotosUseCase: GetPhotosUseCase,
    private val screenManager: ScreenManager
) : ViewModel() {

    private val _screenState = MutableStateFlow(PhotoListState.default())
    val screenState: StateFlow<PhotoListState> = _screenState

    private val stateLock = Mutex()

    init {
        fetchPhotos()
    }

    fun getSpanCount(): Int {
        val windowSize = screenManager.calculateWindowsSizeClass()
        return if (windowSize.windowWidthSizeClass == WindowWidthSizeClass.COMPACT) {
            MOBILE_SPAN_COUNT
        } else {
            TABLET_SPAN_COUNT
        }
    }

    private fun fetchPhotos() {
        getPhotosUseCase.invoke(format = "json", tags = "cats", nojsoncallback = 1).onEach { dataState ->
            dataState.loading.let { isLoading -> updateState { copy(isLoading = isLoading) } }
            dataState.data?.let { photos -> updateState { copy(items = photos) } }
            dataState.error?.let { error -> Log.e(PhotoListViewModel::class.simpleName, "newSearch: $error") }
        }.launchIn(viewModelScope)
    }

    private suspend fun updateState(updater: PhotoListState.() -> PhotoListState) {
        stateLock.withLock {
            _screenState.value = _screenState.value.updater()
        }
    }

    companion object {
        private const val MOBILE_SPAN_COUNT = 1
        private const val TABLET_SPAN_COUNT = 3
    }
}

data class PhotoListState(
    val items: List<Photo>,
    val isLoading: Boolean
) {
    companion object {
        fun default() = PhotoListState(
            items = listOf(),
            isLoading = false
        )
    }
}
