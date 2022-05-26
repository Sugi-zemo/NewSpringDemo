
package com.suganthi.story.ReadingApp;

import com.suganthi.story.ReadingApp.dao.BookRepository;
import com.suganthi.story.ReadingApp.entity.Book;
import com.suganthi.story.ReadingApp.entity.Author;
import com.suganthi.story.ReadingApp.service.BookService;
import org.junit.jupiter.api.Assertions;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {


    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepository bookRepository;

    @Mock
    private Model model;

    @Test
    public void findAllBooksTest() {
        when(bookRepository.findAll()).thenReturn(
                Stream.of(
                        new Book("The Butterflies","Drama"),
                        new Book("The Kingdom","Horror")
                ).collect(Collectors.toList()));

        Assertions.assertEquals(2, bookRepository.findAll().size());

    }

    @Test
    public void deleteBookTest() {
        int id = 1;
        bookRepository.deleteById(id);
        verify(bookRepository, times(1)).deleteById(id);
    }

    @Test
    public void searchByTest(){
        String keyword="crows";
        when(bookRepository.findBystoryNameContainsAllIgnoreCase(keyword)).
                thenReturn(Stream.of(new Book("The Butterflies","Drama"),
                        new Book("The Kingdom","Horror")).collect(Collectors.toList()));
        assertEquals(2,bookService.searchBy(keyword).size());
    }

}