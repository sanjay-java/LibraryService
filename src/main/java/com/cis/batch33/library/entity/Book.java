package com.cis.batch33.library.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="book")
@Data
public class Book {

    @Id
    private Integer bookId;
    private String title;
    private String authorName;
    private Integer yearPublished;
    private Integer quantity;
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookIsbn> bookIsbns;

}
