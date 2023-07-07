package com.example.demo.theater;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class TheaterService {
    private final TheaterRepository theaterRepository;

    @Autowired
    public TheaterService(TheaterRepository theaterRepository) {

        this.theaterRepository = theaterRepository;
    }

    public List<Theater> getTheater() {
        return theaterRepository.findAll();

    }

    public Theater getOne(Long id) {
        Theater theater = theaterRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("no theater with id"));
        return theater;

    }

    public void addNewTheater(Theater theater) {
        Optional<Theater> theaterOptional = theaterRepository.findTheaterByName(theater.getName());
        if (theaterOptional.isPresent()) {
            throw new IllegalStateException("name taken");
        }
        theaterRepository.save(theater);
    }

    public void deleteTheater(Long theaterId) {
        boolean exists = theaterRepository.existsById(theaterId);
        if (!exists) {
            throw new IllegalStateException("Theater doesn't exists.");
        }
        theaterRepository.deleteById(theaterId);


    }

    public Optional<Theater> findById(Long theaterId) {
        return theaterRepository.findById(theaterId);
    }


    @Transactional
    public void updateTheater(Long theaterId,
                              String name
    ) {
        Theater theater = theaterRepository.findById(theaterId).orElseThrow(() -> new IllegalStateException("Theater doesn't exist"));
        if (name != null && name.length() > 0 && !Objects.equals(theater.getName(), name)) {
            theater.setName(name);
        }

    }


    public Theater save(Theater theater) { return theaterRepository.save(theater);
    }
}


