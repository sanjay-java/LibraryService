package com.cis.batch33.library.model;

import com.cis.batch33.library.entity.BookIsbn;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BookDTO {
    private Integer bookId;
    private String title;
    private String authorName;
    private Integer yearPublished;
    private Integer quantity;
    private List<BookIsbnDTO> bookIsbns;
}
