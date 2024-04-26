package com.samuel.workshopmongo.configs;

import com.samuel.workshopmongo.domain.Post;
import com.samuel.workshopmongo.domain.Users;
import com.samuel.workshopmongo.dto.AuthorDTO;
import com.samuel.workshopmongo.repository.PostRepository;
import com.samuel.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        userRepository.deleteAll();
        postRepository.deleteAll();

        Users maria = new Users(null, "Maria Brown", "maria@gmail.com");
        Users alex = new Users(null, "Alex Green", "alex@gmail.com");
        Users bob = new Users(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, simpleDateFormat.parse("21/03/2024"), "Partiu viagem","Vou viajar para São Paulo", new AuthorDTO(maria) );
        Post post2 = new Post(null, simpleDateFormat.parse("23/03/2024"), "Bom dia","Acordei feliz hoje!", new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));
        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.saveAll(Arrays.asList(maria));
    }
}
