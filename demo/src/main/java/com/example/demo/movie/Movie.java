package com.example.demo.movie;

import com.example.demo.director.Director;
import com.example.demo.theater.Theater;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Movie {
    @Id
    @SequenceGenerator(
            name= "movie_sequence",
            sequenceName = "movie_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movie_sequence"
    )
    private Long id;
    private String title;
    private String genre;
    private Integer year;
    @ManyToMany
    @JoinTable(
            name= "featured_theaters",
            joinColumns = @JoinColumn(name="movie_id"),
            inverseJoinColumns = @JoinColumn(name="theater_id")
    )
    private Set<Theater> theaters = new HashSet<>();


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "director_id", referencedColumnName = "id")
    private Director director;

    public Movie() {
    }

    public Movie(Long id,
                 String title,
                 String genre,
                 Integer year) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.year = year;
    }

    public Movie(String title,
                 String genre,
                 Integer year) {
        this.title = title;
        this.genre = genre;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Set<Theater> getTheaters() {
        return theaters;
    }

    public Director getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                '}';
    }
}
