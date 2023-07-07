package com.example.demo.movie;

import com.example.demo.theater.Theater;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies() {
        return movieRepository.findAll();

    }

    public void addNewMovie(Movie movie) {
        Optional<Movie> movieOptional = movieRepository.findMovieByGenre(movie.getGenre());
        if (movieOptional.isPresent()) {
            throw new IllegalStateException("genre taken");
        }
        movieRepository.save(movie);
    }

    public void deleteMovie(Long movieId) {
        boolean exists = movieRepository.existsById(movieId);
        if (!exists) {
            throw new IllegalStateException("Movie doesn't exists.");
        }
        movieRepository.deleteById(movieId);

    }

    public Movie getOne(Long movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalStateException("no theater with id"));
        return movie;

    }

    @Transactional
    public void updateMovie(Long movieId,
                            String title,
                            String genre
    ) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new IllegalStateException("Movie doesn't exist"));
        if (title != null && title.length() > 0 && !Objects.equals(movie.getTitle(), title)) {
            movie.setTitle(title);
        }
        if (genre != null && genre.length() > 0 && !Objects.equals(movie.getGenre(), genre)) {
            Optional<Movie> movieOptional = movieRepository.findMovieByGenre(genre);
            if (movieOptional.isPresent()) {
                throw new IllegalStateException("Genre Taken");

            }
            movie.setGenre(genre);
        }
    }

    public Optional<Movie> findById(Long movieId) {
        return movieRepository.findById(movieId);
    }
}
