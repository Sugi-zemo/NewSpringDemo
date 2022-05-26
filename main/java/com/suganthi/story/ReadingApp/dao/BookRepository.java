package com.suganthi.story.ReadingApp.dao;

import com.suganthi.story.ReadingApp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    public List<Book> findBystoryNameContainsAllIgnoreCase(
            String theStoryName);
}
