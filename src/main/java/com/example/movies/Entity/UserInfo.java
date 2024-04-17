package com.example.movies.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;


}
