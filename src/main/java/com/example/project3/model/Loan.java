package com.example.project3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor
@Data @Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer loan_id;
    @NotNull(message = "user id is required")
    private Integer user_id;
    @NotNull(message = "book id is required")
    private Integer book_id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Book>books;
}
