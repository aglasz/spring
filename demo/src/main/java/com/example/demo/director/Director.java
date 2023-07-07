package com.example.demo.director;

import com.example.demo.movie.Movie;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Director { @Id
@SequenceGenerator(
        name= "director_sequence",
        sequenceName = "director_sequence",
        allocationSize = 1
)
@GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "director_sequence"
)
private Long id;
    private String name;



    @OneToMany(mappedBy = "director")
    private Set<Movie>  movies = new HashSet<>();

    public Director() {
    }

    public Director(Long id,
                 String name) {
        this.id = id;
        this.name = name;

    }

    public Director(String name) {
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

    public Set<Movie> getMovies() {
        return movies;
    }



    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }
}
