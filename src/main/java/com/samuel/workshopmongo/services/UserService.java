package com.samuel.workshopmongo.services;

import com.samuel.workshopmongo.domain.Users;
import com.samuel.workshopmongo.repository.UserRepository;
import com.samuel.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public List<Users> findAll(){
        return userRepository.findAll();
    }

    public Users save(Users users){
        return userRepository.save(users);
    }

    public Users findById(Long id){
        Optional<Users> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

}
