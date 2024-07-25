package com.example.movies.dao;

import com.example.movies.entity.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
