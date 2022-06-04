package com.example.project3.service;

import com.example.project3.exception.InvalidIDException;
import com.example.project3.model.Book;
import com.example.project3.model.Loan;
import com.example.project3.model.User;
import com.example.project3.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoanService {
    private final LoanRepository loanRepository;

    public List<Loan> getLoans(){
        return loanRepository.findAll();
    }
    public void addLoan(Loan loan){
        loanRepository.save(loan);
    }


}
