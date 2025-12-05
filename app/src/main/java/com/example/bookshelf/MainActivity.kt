package com.example.bookshelf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookshelfApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookshelfApp() {
    val scope = rememberCoroutineScope()
    var books by remember { mutableStateOf<List<BookItem>>(emptyList()) }
    var query by remember { mutableStateOf("harry potter") }

    LaunchedEffect(Unit) {
        val response = ApiClient.api.searchBooks(query)
        println("DEBUG: ${response.items?.size} books found")
        books = response.items ?: emptyList()
    }


    Scaffold(
        topBar = { TopAppBar(title = { Text("Bookshelf App") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {

            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                label = { Text("Search Books") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {
                    scope.launch {
                        books = ApiClient.api.searchBooks(query).items ?: emptyList()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Search")
            }

            Spacer(modifier = Modifier.height(10.dp))

            LazyColumn {
                items(books) { book ->
                    BookCard(book)
                }
            }
        }
    }
}

@Composable
fun BookCard(book: BookItem) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {

            AsyncImage(
                model = book.volumeInfo.imageLinks?.thumbnail,
                contentDescription = book.volumeInfo.title,
                modifier = Modifier.size(120.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(book.volumeInfo.title, style = MaterialTheme.typography.titleMedium)

                book.volumeInfo.authors?.let {
                    Text("By: ${it.joinToString()}")
                }
            }
        }
    }
}
