package com.cmsbackend.controller.post_controller.post_vo;

import java.util.Date;
import com.cmsbackend.entity.tags_entity.Tag;
import com.cmsbackend.entity.user_entity.User;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import java.util.List;

@Data
@ApiModel
public class AddRequest {
    Long Id;
    String Content;
    Date created_at;
    List<Long> tag_id;
    String account;
}
