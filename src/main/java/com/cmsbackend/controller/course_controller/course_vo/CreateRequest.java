package com.cmsbackend.controller.course_controller.course_vo;

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
    String Teacher;
}
