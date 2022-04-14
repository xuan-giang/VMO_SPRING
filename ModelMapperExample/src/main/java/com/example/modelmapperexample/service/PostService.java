package com.example.modelmapperexample.service;

import com.example.modelmapperexample.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();

    Post createPost(Post post);

    Post updatePost(long id, Post post);

    void deletePost(long id);

    Post getPostById(long id);
}
