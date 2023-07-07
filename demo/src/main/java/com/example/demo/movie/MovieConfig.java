package com.example.demo.movie;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MovieConfig {
    @Bean
    CommandLineRunner moviecommandLineRunner(MovieRepository repository){
        return args -> {
            Movie titanic = new Movie(
                    "Titanic",
                    "Historical Drama",
                    1997
            );
            Movie twilight = new Movie(
                    "Twilight",
                    "Science Fiction",
                    2008
            );
            Movie candles = new Movie(
                    "Sixteen Candles",
                    "Rom Com",
                    1984
            );
            repository.saveAll(
                    List.of(titanic, twilight, candles)
            );
        };
    }
}
