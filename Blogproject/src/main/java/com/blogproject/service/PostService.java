package com.blogproject.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogproject.dto.PostRequest;
import com.blogproject.exception.NotFoundException;
import com.blogproject.mapper.PostMapper;
import com.blogproject.model.Post;
import com.blogproject.repository.PostRepository;

@Service
@Transactional
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post create(PostRequest request) {
        Post post = PostMapper.toEntity(request);
        return postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public Post getById(Long id) {
        return postRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Post not found: " + id));
    }

    @Transactional(readOnly = true)
    public List<Post> getAll(String term) {
        if (term == null || term.isBlank()) {
            return postRepository.findAll();
        }
        return postRepository.searchByTerm(term);
    }

    public Post update(Long id, PostRequest request) {
        Post existing = getById(id);
        PostMapper.updateEntity(existing, request);
        return postRepository.save(existing);
    }

    public void delete(Long id) {
        Post existing = getById(id);
        postRepository.delete(existing);
    }
}


