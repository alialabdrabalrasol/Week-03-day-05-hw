package com.example.project3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor
@Data @Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer book_id;
    @NotEmpty(message = "please enter a name")
    private String name;
    @NotEmpty(message = "please enter a genre")
    private String genre;

    @ManyToOne
    private User user;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Loan>loans;

}
