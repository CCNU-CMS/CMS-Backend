package com.cmsbackend.controller.comment_controller.comment_vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
@Data
public class InfoResp {
    long id;
    long postId;
    long userId;
    String userName;
    String account;
    String content;
    String commentDate;
    long parentCommentId;

    public InfoResp(long id, long postId, long userId, String userName, String account, String content, String commentDate, long parentCommentId) {
        this.id = id;
        this.postId = postId;
        this.userId = userId;
        this.userName = userName;
        this.account = account;
        this.content = content;
        this.commentDate = commentDate;
        this.parentCommentId = parentCommentId;
    }
}
