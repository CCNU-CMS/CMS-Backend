package com.cmsbackend.controller.user_controller.user_vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;

@Data
public class UpdateInfoRequest {

    @JoinColumn(nullable = true)
    private String name;
    @JoinColumn(nullable = true)
    private String account;
    @JoinColumn(nullable = true)
    private String dept;
    @JoinColumn(nullable = true)
    private String sex;
    @JoinColumn(nullable = true)
    private String avatar;
}


