package com.cmsbackend.controller.comment_controller.comment_vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
@Data
@ApiModel
public class AddRequest {
    long postId;
    long userId;
    String content;
    String commentDate;
    long parentCommentId;
}