package com.example.post.services;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.post.exceptions.RecordNotFoundException;
import com.example.post.models.Post;
import com.example.post.respos.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public Post updatePost(Post post) throws RecordNotFoundException {
		Optional<Post> findById = postRepository.findById(post.getId());
		if (findById.isPresent()) {
			Post updatedPost = findById.get();
			updatedPost.setTitle(post.getTitle());
			updatedPost.setUser(post.getUser());
			return postRepository.save(updatedPost);
		} else {
			throw new RecordNotFoundException("Record not found in DB.");
		}
	}

	public Post savePost(Post post) {
		Instant ins = Instant.now();
		post.setDate(ins);
		return postRepository.save(post);
	}

	public List<Post> getAllPosts() {
		List<Post> allPosts = postRepository.findAll();
		return allPosts.size() > 0 ? allPosts : new ArrayList<Post>();
	}

	public void deletePost(Long id) throws RecordNotFoundException {
		Post post =postRepository.findById(id).orElseThrow(()->new RecordNotFoundException("Record not found in with id",id));
		postRepository.delete(post);
	}
}
