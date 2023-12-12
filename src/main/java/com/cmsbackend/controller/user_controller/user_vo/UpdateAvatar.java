package com.cmsbackend.controller.user_controller.user_vo;

import lombok.Data;

import javax.persistence.JoinColumn;

@Data
public class UpdateAvatar {
    @JoinColumn(nullable = true)
    private String avatar;
}

