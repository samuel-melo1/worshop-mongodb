package com.samuel.workshopmongo.services;

import com.samuel.workshopmongo.domain.Post;
import com.samuel.workshopmongo.domain.Users;
import com.samuel.workshopmongo.dto.UserDTO;
import com.samuel.workshopmongo.repository.PostRepository;
import com.samuel.workshopmongo.repository.UserRepository;
import com.samuel.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

}
