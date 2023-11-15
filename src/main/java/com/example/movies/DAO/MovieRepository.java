package com.example.movies.DAO;

import com.example.movies.Entity.Movie;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface MovieRepository extends JpaRepository<Movie,Integer> {
}
