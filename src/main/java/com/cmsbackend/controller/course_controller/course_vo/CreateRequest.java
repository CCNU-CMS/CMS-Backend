package com.cmsbackend.controller.course_controller.course_vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class CreateRequest {
    String Name;
    String Time;
    String Classroom;
    String Academy;
    String Dept;
    String Description;

    @JsonAlias(value = "t_account")
    String TAccount;
}
