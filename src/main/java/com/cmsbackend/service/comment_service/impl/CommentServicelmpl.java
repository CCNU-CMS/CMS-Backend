package com.cmsbackend.service.comment_service.impl;

import com.cmsbackend.dao.comment_dao.CommentDao;
import com.cmsbackend.entity.comment_entity.Comment;
import com.cmsbackend.service.comment_service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServicelmpl implements CommentService {
    @Autowired
    private  CommentDao commentDao;
    @Override
    public Long save(Comment comment) {
        Comment savedComment = commentDao.save(comment);
        return savedComment.getId();
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentDao.getById(id);
    }


    @Override
    public List<Comment> getCommentsByPostId(Long postId) {
        return commentDao.findByPostId(postId);
    }

    @Override
    public List<Comment> getCommentsByParentCommentId(Long parentCommentId) {
        return commentDao.findByParentCommentId(parentCommentId);
    }
    @Override
    public void deleteCommentById(Long id) {
        commentDao.deleteById(id);
    }
}
