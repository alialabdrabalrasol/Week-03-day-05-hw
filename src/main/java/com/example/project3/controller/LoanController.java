package com.example.project3.controller;

import com.example.project3.dto.ResponseAPI;
import com.example.project3.model.Loan;
import com.example.project3.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/loan")
@RequiredArgsConstructor
public class LoanController {
    Logger log= LoggerFactory.getLogger(LoanController.class);
    private final LoanService loanService;
    @GetMapping
    public ResponseEntity getLoans(){
        log.info("loans are retrieved through getLoans() - LoansController");
        return ResponseEntity.status(HttpStatus.OK).body(loanService.getLoans());
    }
    @PostMapping
    public ResponseEntity addLoan(@RequestBody @Valid Loan loan){
        log.info("a loan is added through addLoan() - LoanController");
        loanService.addLoan(loan);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseAPI("Loan added",HttpStatus.CREATED.value()));
    }


}
