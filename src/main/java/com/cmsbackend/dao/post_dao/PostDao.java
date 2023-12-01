package com.cmsbackend.dao.post_dao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cmsbackend.entity.posts_entity.Post;

import java.io.Serializable;
import java.util.List;
public interface PostDao extends JpaRepository<Post, Long>, Serializable {

    Post findPostById(long id);

    List<Post> findAllPosts(Pageable pageable);
    //根据用户id获取帖子
    List<Post> findPostByUserId(long user_id);

    void deleteById(Long id);
}