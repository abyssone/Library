package com.example.library.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "publicationYear")
    private int publicationYear;
    @Column(name = "rating")
    private int rating;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "book")
    @PrimaryKeyJoinColumn(name = "image")
    private Image image;
    @Column(name = "localDateTime")
    private LocalDateTime localDateTime;
    @PrePersist
    private void init(){
        localDateTime = LocalDateTime.now();
    }

//    private String publishingHouse;
//    private String category;
//    private String description;
//    private short copiesInStoke;
//    private short copiesNumber;
//    private short publicationYear;
}
