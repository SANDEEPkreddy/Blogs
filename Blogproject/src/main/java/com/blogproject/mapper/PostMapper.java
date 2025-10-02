package com.blogproject.mapper;

import java.util.ArrayList;
import java.util.List;

import com.blogproject.dto.PostRequest;
import com.blogproject.dto.PostResponse;
import com.blogproject.model.Post;

public final class PostMapper {

    private PostMapper() {}

    public static Post toEntity(PostRequest request) {
        Post post = new Post();
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setCategory(request.getCategory());
        post.setTags(new ArrayList<>(request.getTags()));
        return post;
    }

    public static void updateEntity(Post post, PostRequest request) {
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setCategory(request.getCategory());
        post.setTags(new ArrayList<>(request.getTags()));
    }

    public static PostResponse toResponse(Post post) {
        PostResponse response = new PostResponse();
        response.setId(post.getId());
        response.setTitle(post.getTitle());
        response.setContent(post.getContent());
        response.setCategory(post.getCategory());
        response.setTags(new ArrayList<>(post.getTags()));
        response.setCreatedAt(post.getCreatedAt());
        response.setUpdatedAt(post.getUpdatedAt());
        return response;
    }

    public static List<PostResponse> toResponseList(List<Post> posts) {
        List<PostResponse> list = new ArrayList<>();
        for (Post post : posts) {
            list.add(toResponse(post));
        }
        return list;
    }
}


