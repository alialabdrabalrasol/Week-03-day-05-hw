package com.example.project3.controller;

import com.example.project3.dto.ResponseAPI;
import com.example.project3.model.Book;
import com.example.project3.service.BookService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/book")
@RequiredArgsConstructor
public class BookController {
    Logger log= LoggerFactory.getLogger(BookController.class);
    private final BookService bookService;
    @GetMapping
    public ResponseEntity getBooks()
    {
        log.info("books are retrieved through getBooks() - BookController");
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooks());
    }
    @PostMapping
    public ResponseEntity addBook(@RequestBody @Valid Book book){
        log.info("a book is added through addBook() - BookController");
        bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseAPI("Book Added",HttpStatus.CREATED.value()));
    }
    @PostMapping("lend/{book_id}/{user_id}")
    public ResponseEntity lendBookToUser(@PathVariable Integer book_id,@PathVariable Integer user_id){
        log.info("book : "+book_id+"is being lent to user : "+user_id+" through lendBookToUser() - LoanController");
        bookService.lendBookToUser(book_id,user_id);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseAPI("Loan successfully done",HttpStatus.CREATED.value()));
    }
    @PostMapping("return/{book_id}")
    public ResponseEntity returnBook(@PathVariable Integer book_id){
        log.info("book"+book_id+"is being return through returnBook() - LoanController");

        return ResponseEntity.status(HttpStatus.CREATED).body( bookService.returnBook(book_id));
    }
}
