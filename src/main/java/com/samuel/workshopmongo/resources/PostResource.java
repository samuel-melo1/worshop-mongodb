package com.samuel.workshopmongo.resources;

import com.samuel.workshopmongo.domain.Post;
import com.samuel.workshopmongo.domain.Users;
import com.samuel.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Post> findPosts(@PathVariable String id){
        Post list = postService.findById(id);
        return ResponseEntity.ok().body(list);
    }

}
