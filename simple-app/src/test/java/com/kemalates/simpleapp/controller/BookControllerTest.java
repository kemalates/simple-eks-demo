package com.kemalates.simpleapp.controller;

import com.kemalates.simpleapp.books.Book;
import com.kemalates.simpleapp.books.BookService;
import com.kemalates.simpleapp.web.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    public void shouldReturnAllBooks() throws Exception {
        List<Book> books = new ArrayList<Book>();
        books.add(Book.builder().id(1).name("Test").isbn("1111").build());
        when(bookService.getAllBooks()).thenReturn(books);

        this.mockMvc.perform(get("/api/v1/book")).andDo(print()).andExpect(status().isOk());
    }
}
