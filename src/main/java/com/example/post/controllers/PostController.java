package com.example.post.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.post.exceptions.RecordNotFoundException;
import com.example.post.models.Post;
import com.example.post.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostService postService;

	@PutMapping("/post")
	public ResponseEntity<Post> updatePost(@RequestBody Post post) throws RecordNotFoundException {
		Post updatedPost = postService.updatePost(post);
		return new ResponseEntity<>(updatedPost, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Post>> getAllPosts() {
		List<Post> allPosts = postService.getAllPosts();
		return new ResponseEntity<>(allPosts, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/post")
	public ResponseEntity<Post> savePost(@RequestBody Post post) throws RecordNotFoundException {
		Post newPost = postService.savePost(post);
		return new ResponseEntity<>(newPost, new HttpHeaders(), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePost(@PathVariable Long id) throws RecordNotFoundException{
		postService.deletePost(id);
		return ResponseEntity.ok().build();
	}

}
