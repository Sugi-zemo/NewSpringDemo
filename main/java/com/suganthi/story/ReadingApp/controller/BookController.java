package com.suganthi.story.ReadingApp.controller;


import com.suganthi.story.ReadingApp.entity.Book;
import com.suganthi.story.ReadingApp.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("books")
public class BookController {

    private BookService bookService;

    public BookController(BookService thebookService) {
        bookService = thebookService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listBooks(Model theModel) {

        // get employees from db
        List<Book> theBooks = bookService.findAll();

        // add to the spring model
        theModel.addAttribute("books", theBooks);

        return "list-books";
    }



    @GetMapping("/delete")
    public String delete(@RequestParam("bookId") int theId) {

        // delete the employee
        bookService.deleteById(theId);

        // redirect to /employees/list
        return "redirect:/books/list";

    }

    @GetMapping("/show")
     public String showStory(@RequestParam("bookId") int theId){
      if(theId == 1){
          return "1";
      }
      if (theId == 2){
          return "2";
      }
        if(theId == 3){
            return "3";
        }
        if (theId == 4){
            return "4";
        }
        if(theId == 5){
            return "5";
        }
        if (theId == 6){
            return "6";
        }
        if (theId == 7){
            return "7";
        }
        return null;
    }

    @GetMapping("/search")
    public String search(@RequestParam("storyName") String theStoryName,
                         Model theModel) {

        // check names, if both are empty then just give list of all employees

        if (theStoryName.trim().isEmpty() ) {
            return "redirect:/books/list";
        }
        else {
            // else, search by first name and last name
            List<Book> theBooks =
                    bookService.searchBy(theStoryName);

            // add to the spring model
            theModel.addAttribute("books", theBooks);

            // send to list-employees
            return "list-books";
        }

    }


}