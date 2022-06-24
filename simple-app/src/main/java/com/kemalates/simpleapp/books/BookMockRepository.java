package com.kemalates.simpleapp.books;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
class BookMockRepository implements BookRepository{

    private List<Book> books = new ArrayList<>();

    public BookMockRepository() {
        this.books.add(Book.builder().id(1).name("Demo1").isbn("12kdfnaf12312321").build());
        this.books.add(Book.builder().id(2).name("Demo2").isbn("12kdfnaf12312321").build());
        this.books.add(Book.builder().id(3).name("Demo3").isbn("12kdfnaf12312321").build());
        this.books.add(Book.builder().id(4).name("Demo4").isbn("12kdfnaf12312321").build());
    }

    @Override
    public List<Book> findAllBooks() {
        return this.books;
    }

    @Override
    public Book getBookById(int bookId) {
        return null;
    }
}
