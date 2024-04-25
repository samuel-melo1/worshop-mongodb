package com.samuel.workshopmongo.dto;

import com.samuel.workshopmongo.domain.Users;

public class AuthorDTO {

    private String id;
    private String name;

    public AuthorDTO(){
    }

    public AuthorDTO(Users obj){
        this.id = obj.getId();
        this.name = obj.getName();
    }
}
