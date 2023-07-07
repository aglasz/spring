package com.example.demo.theater;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class TheaterConfig {
    @Bean
    CommandLineRunner theatercommandLineRunner(TheaterRepository repository){
        return args -> {
            Theater titanic = new Theater(
                    "Malco"
            );
            Theater twilight = new Theater(
                    "Cenimark"

            );
            Theater candles = new Theater(
                    "Imax"
            );
            repository.saveAll(
                    List.of(titanic, twilight, candles)
            );
        };
    }
}
