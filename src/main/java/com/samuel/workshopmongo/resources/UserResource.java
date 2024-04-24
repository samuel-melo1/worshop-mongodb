package com.samuel.workshopmongo.resources;

import com.samuel.workshopmongo.domain.Users;
import com.samuel.workshopmongo.dto.UserDTO;
import com.samuel.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll(){
        List<Users> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
    @RequestMapping (method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody UserDTO userDto){
        Users obj = service.fromDto(userDto);
        obj = service.save(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        Users list = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(list));
    }
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping (value = "{id}",method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody UserDTO userDto, @PathVariable Long id ){
        Users obj = service.fromDto(userDto);
        obj.setId(id);
        obj = service.save(obj);
        return ResponseEntity.noContent().build();
    }

}
