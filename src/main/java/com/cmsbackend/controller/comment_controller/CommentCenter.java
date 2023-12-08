package com.cmsbackend.controller.comment_controller;

import com.cmsbackend.entity.comment_entity.Comment;
import com.cmsbackend.entity.user_entity.User;
import com.cmsbackend.service.comment_service.CommentService;
import com.cmsbackend.service.user_service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cmsbackend.controller.comment_controller.comment_vo.AddRequest;
import com.cmsbackend.controller.comment_controller.comment_vo.InfoResp;

import java.util.*;
@Slf4j
@RestController
@RequestMapping("/comment")
@CrossOrigin(value = "*")
@Api(tags = {"评论接口"})
public class CommentCenter {
    private final CommentService commentService;
    private final UserService userService;
    @Autowired
    public CommentCenter(CommentService commentService, UserService userService) {
        this.commentService = commentService;
        this.userService = userService;
    }
    @ApiOperation("新增评论")
    @PostMapping(value = "/new", headers = "Content-Type=application/json", produces = "application/json")
    public String addComment(@RequestBody AddRequest request) {
        log.info("Adding new comment:{}",request.getContent());
        Comment comment = new Comment();
        //获取用户account
        String account = request.getAccount();
        //获取用户信息
        User user = userService.getUserByAccount(account);
        //设置评论属性
        comment.setPostId(request.getPostId());
        comment.setUser(user);
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
//    @ApiOperation("根据评论ID获取评论信息")
//    @GetMapping("/info/{id}")
//    public Comment getCommentInfo(@PathVariable Long id) {
//        log.info("Fetching comment by ID: {}", id);
//        return commentService.getCommentById(id);
//    }


    @ApiOperation("根据帖子ID查询评论")
    @GetMapping("/post/{postId}")
    public List<InfoResp> getCommentsByPostId(@PathVariable Long postId) {
        log.info("Fetching comments by post ID: {}", postId);
        List<Comment> comments = commentService.getCommentsByPostId(postId);

        // Convert Comment
        List<InfoResp> infoResp = new ArrayList<>();
        for (Comment comment : comments) {
            InfoResp Resp = new InfoResp(comment.getId(), comment.getPostId(), comment.getUser().getId(), comment.getUser().getName(), comment.getUser().getAccount(), comment.getContent(), comment.getCommentDate(), comment.getParentCommentId());
            infoResp.add(Resp);
        }
        return infoResp;
    }

    @ApiOperation("根据父评论ID查询评论")
    @GetMapping("/parent/{parentCommentId}")
    public List<InfoResp> getCommentsByParentCommentId(@PathVariable Long parentCommentId) {
        log.info("Fetching comments by parent comment ID: {}", parentCommentId);
        List<Comment> comments = commentService.getCommentsByParentCommentId(parentCommentId);
        // Convert Comment
        List<InfoResp> infoResp = new ArrayList<>();
        for (Comment comment : comments) {
            InfoResp Resp = new InfoResp(comment.getId(), comment.getPostId(), comment.getUser().getId(), comment.getUser().getName(), comment.getUser().getAccount(), comment.getContent(), comment.getCommentDate(), comment.getParentCommentId());
            infoResp.add(Resp);
        }
        return infoResp;
    }

    @ApiOperation("删除评论")
    @DeleteMapping("/{id}")
    public void deleteCommentById(@PathVariable Long id) {
        log.info("Deleting comment by ID: {}", id);
        commentService.deleteCommentById(id);
    }
}
