package com.example.movies.dao;

import com.example.movies.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Categories,Integer> {

    Optional<Categories> findByCategory(String category);
}
