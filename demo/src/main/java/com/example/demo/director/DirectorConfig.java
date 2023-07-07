package com.example.demo.director;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class DirectorConfig {
        @Bean
        CommandLineRunner directorcommandLineRunner(DirectorRepository repository){
            return args -> {
                Director titanic = new Director(
                        "James Cameron"
                );
                Director twilight = new Director(
                        "Catherine Hardwicke"

                );
                Director candles = new Director(
                        "John Hughes"
                );
                repository.saveAll(
                        List.of(titanic, twilight, candles)
                );
            };
        }
    }
