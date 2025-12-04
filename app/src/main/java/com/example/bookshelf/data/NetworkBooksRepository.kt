package com.example.bookshelf.data

import com.example.bookshelf.network.BookItem
import com.example.bookshelf.networkimport.BookshelfApiService

class NetworkBooksRepository(
    private val bookshelfApiService: BookshelfApiService
) : BooksRepository {

    override suspend fun getBooks(query: String): List<BookItem> {
        // We call the API and return the list of items.
        // If items is null (no results), return an empty list.
        return bookshelfApiService.bookSearch(query).items ?: emptyList()
    }
}
