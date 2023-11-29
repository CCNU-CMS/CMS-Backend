package com.cmsbackend.controller.user_controller.user_vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class AddRequest {
    String Account;
    Long Identity;
    String Password;
    String Name;
}
