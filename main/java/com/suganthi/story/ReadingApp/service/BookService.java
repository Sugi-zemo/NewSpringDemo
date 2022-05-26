package com.suganthi.story.ReadingApp.service;

import com.suganthi.story.ReadingApp.entity.Book;

import java.util.List;

public interface BookService {



        public List<Book> findAll();


        public void deleteById(int theId);


        List<Book> searchBy(String theStoryName);
}
