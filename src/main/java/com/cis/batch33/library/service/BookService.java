package com.cis.batch33.library.service;

import com.cis.batch33.library.entity.Book;
import com.cis.batch33.library.entity.BookIsbn;
import com.cis.batch33.library.model.BookDTO;
import com.cis.batch33.library.model.BookIsbnDTO;
import com.cis.batch33.library.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;
    public BookDTO getBook(Integer bookId) {
        Book book =  bookRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException());
        return  modelMapper.map(book, BookDTO.class);
    }

    public void deleteBook(Integer bookId) {
        Book book =  bookRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException());
        bookRepository.delete(book);
    }

    public BookDTO updateBook(BookDTO bookDto) {
        Book b = modelMapper.map(bookDto, Book.class);
        Book returnBook = bookRepository.save(b);
        return modelMapper.map(returnBook, BookDTO.class);
    }

    public BookDTO createBook(BookDTO bookDto) {
        Random r = new Random();
        bookDto.setBookId(r.nextInt(Integer.MAX_VALUE));
        Book b = modelMapper.map(bookDto, Book.class);
        List<BookIsbn> bookIsbns = new ArrayList<>(b.getQuantity());
        for(int i =0; i< b.getQuantity();i++){
            BookIsbn bi = new BookIsbn();
            bi.setIsbn(r.nextInt(Integer.MAX_VALUE));
            bi.setBook(b);
            bookIsbns.add(bi);
        }

        b.setBookIsbns(bookIsbns);
        Book rb = bookRepository.save(b);
        return modelMapper.map(rb, BookDTO.class);
    }

    public List<BookDTO> getAllBooks() {
       List<Book> books = bookRepository.findAll();
       return books.stream().map(b -> {
            return modelMapper.map(b, BookDTO.class);
       }).collect(Collectors.toList());
    }
}
