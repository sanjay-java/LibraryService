package com.cis.batch33.library.model;

import com.cis.batch33.library.entity.Book;
import com.cis.batch33.library.entity.Checkout;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BookIsbnDTO {
    private Integer isbn;
    private Integer bookId;
    private List<CheckoutDTO> checkouts;
}
