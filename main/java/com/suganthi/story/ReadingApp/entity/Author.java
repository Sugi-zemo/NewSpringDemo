package com.suganthi.story.ReadingApp.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @NotNull(message = "is required")
    @Size(min = 2,message = "please specify at least two characters")
    @Column(name = "first_name")
    private String first_name;

    @NotNull(message = "is required")
    @Size(min = 2,message = "please specify at least two characters")
    @Column(name = "last_name")
    private String last_name;

    @NotNull(message = "is required")
    @Size(min = 7,message = "please specify at least two characters")
    @Column(name = "email")
    private String email;


    //mapped by= author
    @OneToMany(mappedBy = "author",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Book> books;

    public Author(String first_name, String last_name, String email, List<Book> books) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.books = books;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", books=" + books +
                '}';
    }
}