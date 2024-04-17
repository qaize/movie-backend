package com.example.movies.DAO;

import com.example.movies.Entity.Movie;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface MovieRepository extends JpaRepository<Movie,Integer> {

    @Query("""
        select m
        from Movie as m
        where m.id = :movieId
    """
    )
    Optional<Movie> findMovieByName(@Param("movieId")Integer movieId);

    @Query("""
        select m
        from Movie as m
        where m.id = :movieId AND m.isActive = true
    """
    )
    Movie findActiveMovieById(@Param("movieId")Integer Movieid);

    @Query("""
        select m
        from Movie as m
        where m.isActive = true
""")
    Page findAllActiveMovie(Pageable pagination);
}
