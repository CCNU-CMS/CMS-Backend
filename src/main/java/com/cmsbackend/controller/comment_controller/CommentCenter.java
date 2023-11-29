package com.cmsbackend.controller.comment_controller;

import com.cmsbackend.entity.comment_entity.Comment;
import com.cmsbackend.service.comment_service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cmsbackend.controller.comment_controller.comment_vo.AddRequest;

import java.util.*;
@Slf4j
@RestController
@RequestMapping("/comment")
@CrossOrigin(value = "*")
@Api(tags = {"评论接口"})
public class CommentCenter {
    private final CommentService commentService;
    @Autowired
    public CommentCenter(CommentService commentService) {
        this.commentService = commentService;
    }
    @ApiOperation("新增评论")
    @PostMapping(value = "/new", headers = "Content-Type=application/json", produces = "application/json")
    public String addComment(@RequestBody AddRequest request) {
        log.info("Adding new comment:{}",request.getContent());
        Comment comment = new Comment();
        //设置评论属性
        comment.setPostId(request.getPostId());
        comment.setUserId(request.getUserId());
        comment.setContent(request.getContent());
        comment.setCommentDate(request.getCommentDate());
        comment.setParentCommentId(request.getParentCommentId());
        try{
            commentService.save(comment);
            return String.format("新增评论 %d 成功!", comment.getId());
        }catch (Exception e){
            log.error("Failed to add commment", e);
            throw new RuntimeException("Failed to add commment", e);
        }
    }
    @ApiOperation("根据评论ID获取评论信息")
    @GetMapping("/info/{id}")
    public Comment getCommentInfo(@PathVariable Long id) {
        log.info("Fetching comment by ID: {}", id);
        return commentService.getCommentById(id);
    }


    @ApiOperation("根据帖子ID查询评论")
    @GetMapping("/post/{postId}")
    public List<Comment> getCommentsByPostId(@PathVariable Long postId) {
        log.info("Fetching comments by post ID: {}", postId);
        return commentService.getCommentsByPostId(postId);
    }

    @ApiOperation("根据父评论ID查询评论")
    @GetMapping("/parent/{parentCommentId}")
    public List<Comment> getCommentsByParentCommentId(@PathVariable Long parentCommentId) {
        log.info("Fetching comments by parent comment ID: {}", parentCommentId);
        return commentService.getCommentsByParentCommentId(parentCommentId);
    }

    @ApiOperation("删除评论")
    @DeleteMapping("/{id}")
    public void deleteCommentById(@PathVariable Long id) {
        log.info("Deleting comment by ID: {}", id);
        commentService.deleteCommentById(id);
    }
}
