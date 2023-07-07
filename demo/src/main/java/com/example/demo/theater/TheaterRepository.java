package com.example.demo.theater;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
    @Query("SELECT s FROM Theater s WHERE s.name= ?1")
    Optional<Theater> findTheaterByName(String name);
}
