package com.cmsbackend.service.comment_service;

import com.cmsbackend.entity.comment_entity.Comment;

import java.util.List;

public interface CommentService {

    // 根据评论 ID 获取评论
    Comment getCommentById(Long id);


    // 根据帖子（Post）ID 查询评论
    List<Comment> getCommentsByPostId(Long postId);

    // 根据父评论 ID 查询评论
    List<Comment> getCommentsByParentCommentId(Long parentCommentId);

    // 保存评论
    Long save(Comment comment);

    // 删除评论
    void deleteCommentById(Long id);
}
