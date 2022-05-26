package com.suganthi.story.ReadingApp.entity;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@Entity
@Table(name = "story")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @NotNull(message = "is required")
    @Size(min=2,message = "please specify at least two characters")
    @Column(name = "story_name")
    private String storyName;

    @NotNull(message = "is required")
    @Size(min=2,message = "please specify at least two characters")
    @Column(name = "story_type")
    private String story_type;



    //many books can belong to one author
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "author_id")
    private Author author;

    public Book(String story_name, String story_type) {
        this.storyName = storyName;
        this.story_type = story_type;

    }

    public String getStory_name() {
        return storyName;
    }

    public void setStory_name(String story_name) {
        this.storyName = story_name;
    }

    public String getStory_type() {
        return story_type;
    }

    public void setStory_type(String story_type) {
        this.story_type = story_type;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", storyName='" + storyName + '\'' +
                ", story_type='" + story_type + '\'' +
                ", author=" + author +
                '}';
    }
}
