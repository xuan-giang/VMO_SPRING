package com.example.modelmapperexample.service;

import com.example.modelmapperexample.entity.Post;
import com.example.modelmapperexample.exeption.ResourceNotFoundException;
import com.example.modelmapperexample.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        super();
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(long id, Post postRequest) {
//        Post post = postRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
//
//        post.setTitle(postRequest.getTitle());
//        post.setDescription(postRequest.getDescription());
//        post.setContent(postRequest.getContent());
//        return postRepository.save(post);
        return null;
    }

    @Override
    public void deletePost(long id) {

    }

    @Override
    public Post getPostById(long id) {
        return null;
    }
}
