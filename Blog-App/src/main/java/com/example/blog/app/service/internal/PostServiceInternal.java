package com.example.blog.app.service.internal;

import com.example.blog.app.entity.Post;
import com.example.blog.app.payload.PostDto;
import com.example.blog.app.repository.PostRepository;
import com.example.blog.app.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostServiceInternal implements PostService {

    private PostRepository postRepository;

    private Post mapToPost(PostDto postDto) {
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }

    private PostDto mapToPostDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        return postDto;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToPost(postDto);

        Post savedPost = postRepository.save(post);

        return mapToPostDto(savedPost);

    }
}
