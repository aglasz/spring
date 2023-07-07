package com.example.demo.director;
import com.example.demo.movie.Movie;
import com.example.demo.movie.MovieService;
import com.example.demo.theater.Theater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(path = "api/v1/director")

public class DirectorController {
    private final DirectorService directorService;
    private final MovieService movieService;

    @Autowired
    public DirectorController(DirectorService directorService, MovieService movieService) {

        this.directorService = directorService;
        this.movieService = movieService;
    }
    @GetMapping
    public List<Director> getDirectors() {
        return directorService.getDirectors();
    }
    @PostMapping
    public void registerNewDirector(@RequestBody Director director) {
        directorService.addNewDirector(director);
    }
    @DeleteMapping(path = "{directorId}")
    public void deleteDirector(@PathVariable("directorId") Long directorId) {
        directorService.deleteDirector(directorId);
    }
    @PutMapping(path = "{directorId}")
    public void updateDirector(
            @PathVariable("directorId") Long directorId,
            @RequestParam(required = false) String name)
    {
        directorService.updateDirector(directorId, name);
    }

    @PutMapping("/{directorId}/movies/{movieId}")
    public Director addMovietoDirector(
            @PathVariable Long directorId,
            @PathVariable Long movieId
    ) {
        Director director = directorService.findById(directorId).get();
        Movie movie = movieService.findById(movieId).get();
        director.addMovie(movie);

        return directorService.save(director);
    }
}
