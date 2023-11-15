package com.example.movies.DAO;

import com.example.movies.Entity.Categories;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CategoriesRepository extends JpaRepository<Categories,Integer> {
}
