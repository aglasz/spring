package com.example.demo.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository
        extends JpaRepository<Movie, Long> {
    @Query("SELECT s FROM Movie s WHERE s.genre= ?1")
    Optional<Movie> findMovieByGenre(String genre);
}
