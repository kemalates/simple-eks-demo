package com.kemalates.simpleapp.books;

import java.util.List;

interface BookRepository {

    List<Book> findAllBooks();

    Book getBookById(int bookId);
}
