package com.example.demo.director;
import com.example.demo.theater.Theater;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class DirectorService {
    private final DirectorRepository directorRepository;

    @Autowired
    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public List<Director> getDirectors() {
        return directorRepository.findAll();

    }

    public void addNewDirector(Director director) {
        Optional<Director> directorOptional = directorRepository.findDirectorByName(director.getName());
        if (directorOptional.isPresent()) {
            throw new IllegalStateException("name taken");
        }
        directorRepository.save(director);
    }

    public void deleteDirector(Long directorId) {
        boolean exists = directorRepository.existsById(directorId);
        if (!exists) {
            throw new IllegalStateException("Director doesn't exists.");
        }
        directorRepository.deleteById(directorId);

    }

    @Transactional
    public void updateDirector(Long directorId,
                            String name
    ) {
        Director director = directorRepository.findById(directorId).orElseThrow(() -> new IllegalStateException("Director doesn't exist"));
        if (name != null && name.length() > 0 && !Objects.equals(director.getName(), name)) {
            director.setName(name);
        }

        }

    public Optional<Director> findById(Long directorId) {
        return directorRepository.findById(directorId);

    }

    public Director save(Director director) {  return directorRepository.save(director);
    }
}

