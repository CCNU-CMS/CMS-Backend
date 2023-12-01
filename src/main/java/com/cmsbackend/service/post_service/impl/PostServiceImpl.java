package com.cmsbackend.service.post_service.impl;

import com.cmsbackend.dao.post_dao.PostDao;
import com.cmsbackend.entity.posts_entity.Post;
import com.cmsbackend.service.post_service.PostService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostDao postDao;

    public PostServiceImpl(PostDao postDao)
    {
        this.postDao = postDao;
    }
    @Override
    public long save(Post post) {
        // 调用 postDao 的 save 方法将 Post 对象保存到数据库
        postDao.save(post);
        // 返回保存后的 Post 对象的 ID
        return post.getId();
    }

    @Override
    public List<Post> findAll(Integer pageNum, Integer pageSize){
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        List<Post> posts = postDao.findAllPosts(pageable);
        return posts;
    }

    @Override
    public List<Post> findPostByUserId(long user_id){

        List<Post> posts = postDao.findPostByUserId(user_id);
        return posts;
    }

    @Override
    public Post findPostById(long id){
        Post post = postDao.findPostById(id);
        return post;
    }

    @Override
    public void deleteById(long id) {
        postDao.deleteById(id);
    }
}
