package com.example.bookshelf.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Book(
    @SerialName("title")
    val title: String,

    @SerialName("author")
    val author: String,

    @SerialName("description")
    val description: String,

    @SerialName("publisher")
    val publisher: String,

    @SerialName("book_image")
    val bookImage: String? = null,

    @SerialName("amazon_product_url")
    val amazonProductUrl: String? = null
)