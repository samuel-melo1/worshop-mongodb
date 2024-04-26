package com.samuel.workshopmongo.dto;

import com.samuel.workshopmongo.domain.Users;

import java.io.Serializable;

public class AuthorDTO implements Serializable {

    private String id;
    private String name;

    public AuthorDTO(){
    }

    public AuthorDTO(Users obj){
        this.id = obj.getId();
        this.name = obj.getName();
    }
}
