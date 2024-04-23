package com.samuel.workshopmongo.services;

import com.samuel.workshopmongo.domain.Users;
import com.samuel.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
