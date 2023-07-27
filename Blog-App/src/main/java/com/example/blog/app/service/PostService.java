package com.example.blog.app.service;

import com.example.blog.app.payload.PostDto;

public interface PostService {

    PostDto createPost(PostDto postDto);
}
