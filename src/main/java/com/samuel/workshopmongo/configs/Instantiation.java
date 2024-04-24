package com.samuel.workshopmongo.configs;

import com.samuel.workshopmongo.domain.Users;
import com.samuel.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        Users maria = new Users(1L, "Maria Brown", "maria@gmail.com");
        Users alex = new Users(2L, "Alex Green", "alex@gmail.com");
        Users bob = new Users(3L, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, alex, bob));
    }
}
