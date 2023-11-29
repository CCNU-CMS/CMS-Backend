package com.cmsbackend.service.post_service;

import com.cmsbackend.entity.posts_entity.Post;

import java.util.List;

public interface PostService {

    long save(Post post);

    List<Post> findPostByUserId(long user_id);

    Post findPostById(long id);
    void deleteById(long id);

}
