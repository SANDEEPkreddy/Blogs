package com.blogproject.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogproject.dto.PostRequest;
import com.blogproject.dto.PostResponse;
import com.blogproject.mapper.PostMapper;
import com.blogproject.model.Post;
import com.blogproject.service.PostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/posts")
@Validated
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostResponse> create(@Valid @RequestBody PostRequest request) {
        Post created = postService.create(request);
        PostResponse response = PostMapper.toResponse(created);
        return ResponseEntity.created(URI.create("/posts/" + created.getId())).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponse> update(@PathVariable Long id, @Valid @RequestBody PostRequest request) {
        Post updated = postService.update(id, request);
        return ResponseEntity.ok(PostMapper.toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getOne(@PathVariable Long id) {
        Post post = postService.getById(id);
        return ResponseEntity.ok(PostMapper.toResponse(post));
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> getAll(@RequestParam(value = "term", required = false) String term) {
        List<Post> posts = postService.getAll(term);
        return new ResponseEntity<>(PostMapper.toResponseList(posts), HttpStatus.OK);
    }
}


