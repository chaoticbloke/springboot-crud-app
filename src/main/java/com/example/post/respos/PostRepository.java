package com.example.post.respos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.post.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
