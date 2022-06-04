package com.example.project3.service;

import com.example.project3.exception.InvalidIDException;
import com.example.project3.model.Book;
import com.example.project3.model.Loan;
import com.example.project3.model.User;
import com.example.project3.repository.BookRepository;
import com.example.project3.repository.LoanRepository;
import com.example.project3.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final LoanRepository loanRepository;
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }
    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void lendBookToUser(Integer book_id, Integer user_id) {
        Optional<Book>book=bookRepository.findById(book_id);
        if(book.isEmpty()){throw new InvalidIDException("Book not found");}

        Optional<User>user=userRepository.findById(user_id);
        if(user.isEmpty()){throw new InvalidIDException("User not found");}

        Loan loan=new Loan();
        loan.setBook_id(book_id);
        loan.setUser_id(user_id);
        loan.setBooks(new HashSet<>());
        book.get().getLoans().add(loan);
        book.get().setUser(user.get());
        bookRepository.save(book.get());
//
    }

    public Set<Loan> returnBook(Integer book_id) {
        Optional<Book>book=bookRepository.findById(book_id);
        if(book.isEmpty()){
            throw new InvalidIDException("Book not found");
        }
        return book.get().getLoans();
    }
}
