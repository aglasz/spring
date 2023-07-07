package com.example.demo.theater;

import com.example.demo.movie.Movie;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Theater {
    @Id
    @SequenceGenerator(
            name= "theater_sequence",
            sequenceName = "theater_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "theater_sequence"
    )
    private Long id;
    private String name;

  @ManyToMany(mappedBy = "theaters")
    private Set<Movie> featuredMovies = new HashSet<>();

    public Theater() {
    }

    public Theater(Long id,
                    String name) {
        this.id = id;
        this.name = name;

    }

    public Theater(String name) {
        this.name = name;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Movie> getFeaturedMovies() {
        return featuredMovies;
    }

    @Override
    public String toString() {
        return "Theater{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }

    public void addMovie(Movie movie) {
        featuredMovies.add(movie);
    }
}
