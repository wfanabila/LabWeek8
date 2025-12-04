package com.example.bookshelf

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelf.model.Book
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface BookshelfUiState {
    data object Loading : BookshelfUiState
    data class Success(val books: List<Book>) : BookshelfUiState
    data class Error(val exception: Throwable? = null) : BookshelfUiState
}

class BookshelfViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<BookshelfUiState>(BookshelfUiState.Loading)
    val uiState: StateFlow<BookshelfUiState> = _uiState.asStateFlow()

    init {
        getBooks()
    }

    fun getBooks() {
        viewModelScope.launch {
            _uiState.value = BookshelfUiState.Loading
            try {
                val result = NYTApi.retrofitService.getBooks()
                _uiState.value = BookshelfUiState.Success(result.results.books)
            } catch (e: IOException) {
                _uiState.value = BookshelfUiState.Error(e)
            } catch (e: Exception) {
                _uiState.value = BookshelfUiState.Error(e)
            }
        }
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                BookshelfViewModel()
            }
        }
    }
}