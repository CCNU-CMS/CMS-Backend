package com.cmsbackend.controller.user_controller.user_vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;

@Data
public class UpdateInfoRequest {

    @JoinColumn(nullable = true)
    private String sex;
    @JoinColumn(nullable = true)
    private String dept;
    @JoinColumn(nullable = true)
    private String name;
    @JoinColumn(nullable = true)
    private String address;
    @JoinColumn(nullable = true)
    private String certificate_code;
    @JoinColumn(nullable = true)
    private String certificate_image;
    @JoinColumn(nullable = true)
    private String contact_people;
}


