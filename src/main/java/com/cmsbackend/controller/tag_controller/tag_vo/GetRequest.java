package com.cmsbackend.controller.tag_controller.tag_vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class GetRequest {
    long Id;
    int Type;
    String Name;
}
