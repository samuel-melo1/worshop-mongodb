package com.samuel.workshopmongo.resources;

import com.samuel.workshopmongo.domain.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Users>> findAll(){
        Users maria = new Users(1L, "maria", "maria@gmail.com");
        Users bruno = new Users(2L, "bruno", "bruno@gmail.com");
        List<Users> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, bruno));
        return ResponseEntity.ok().body(list);
    }

}
