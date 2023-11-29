package com.cmsbackend.dao.comment_dao;

import com.cmsbackend.entity.comment_entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CommentDao extends JpaRepository<Comment, Long> {
    //根据评论 ID 获取评论
    Comment getById(Long id);

    //根据帖子（Post）ID 查询评论
    List<Comment> findByPostId(Long postId);

    //根据父评论 ID 查询评论
    List<Comment> findByParentCommentId(Long parentCommentId);

    void deleteById(Long id);

}
