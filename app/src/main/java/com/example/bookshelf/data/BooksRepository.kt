package com.example.bookshelf.data

import com.example.bookshelf.networkimport.BookItem

interface BooksRepository {
    // Function to get the list of books
    suspend fun getBooks(query: String): List<BookItem>
}
