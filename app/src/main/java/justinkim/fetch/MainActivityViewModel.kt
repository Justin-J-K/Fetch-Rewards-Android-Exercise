package justinkim.fetch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import justinkim.fetch.model.FetchItem
import justinkim.fetch.repository.FetchRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    private val fetchRepository = FetchRepository()
    private val _items: MutableStateFlow<List<FetchItem>> = MutableStateFlow(emptyList())
    val items: StateFlow<List<FetchItem>>
        get() = _items.asStateFlow()

    init {
        viewModelScope.launch {
            _items.value = fetchRepository.fetchSortedValidItems()
        }
    }

}