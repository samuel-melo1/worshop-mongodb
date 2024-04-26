package com.samuel.workshopmongo.repository;

import com.samuel.workshopmongo.domain.Post;
import com.samuel.workshopmongo.domain.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
