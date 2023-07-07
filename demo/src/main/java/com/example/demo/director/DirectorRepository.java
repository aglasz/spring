package com.example.demo.director;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {

    @Query("SELECT s FROM Director s WHERE s.name= ?1")
    Optional<Director> findDirectorByName(String name);
}



