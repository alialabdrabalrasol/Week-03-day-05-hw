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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    @NotEmpty(message = "please enter a username")
    private String username;
    @NotEmpty(message = "please enter a password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Book>books;
}
