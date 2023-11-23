package com.cmsbackend.controller.user_controller.user_vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class UpdatePswRequest {
    @JsonAlias(value = "old_password")
    String OldPassword;
    @JsonAlias(value = "new_password")
    String NewPassword;
}
