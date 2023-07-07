package com.example.demo.theater;
import com.example.demo.movie.Movie;
import com.example.demo.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "api/v1/theater")
public class TheaterController {
    private final TheaterService theaterService;
    private final MovieService movieService;

    @Autowired
    public TheaterController(TheaterService theaterService, MovieService movieService) {

        this.theaterService = theaterService;
        this.movieService = movieService;
    }
    @GetMapping
    public List<Theater> getTheater() {

        return theaterService.getTheater();
    }
    @PostMapping
    public void registerNewTheater(@RequestBody Theater theater) {

        theaterService.addNewTheater(theater);
    }
    @DeleteMapping(path = "{theatherId}")
    public void deleteTheater(@PathVariable("theaterId") Long theaterId) {

        theaterService.deleteTheater(theaterId);
    }
    @PutMapping(path = "{theaterId}")
    public void updateTheater(
            @PathVariable("theaterId") Long theaterId,
            @RequestParam(required = false) String name)
    {
        theaterService.updateTheater(theaterId, name);
    }

    @PutMapping("/{theaterId}/movies/{movieId}")
    public Theater addMovietoTheater(
            @PathVariable Long theaterId,
            @PathVariable Long movieId
    ) {
        Theater theater = theaterService.findById(theaterId).get();
        Movie movie = movieService.findById(movieId).get();
        theater.addMovie(movie);

        return theaterService.save(theater);
    }

    @GetMapping(path= "{theaterId}")
    public Theater getOne(@PathVariable("theaterId") Long theaterId) {return theaterService.getOne(theaterId);}
}
