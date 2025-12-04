package com.example.bookshelf.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NYTResponse(
    @SerialName("status")
    val status: String,

    @SerialName("copyright")
    val copyright: String,

    @SerialName("num_results")
    val numResults: Int,

    @SerialName("results")
    val results: Results
)

@Serializable
data class Results(
    @SerialName("list_name")
    val listName: String,

    @SerialName("list_name_encoded")
    val listNameEncoded: String,

    @SerialName("bestsellers_date")
    val bestsellersDate: String,

    @SerialName("published_date")
    val publishedDate: String,

    @SerialName("books")
    val books: List<Book>
)