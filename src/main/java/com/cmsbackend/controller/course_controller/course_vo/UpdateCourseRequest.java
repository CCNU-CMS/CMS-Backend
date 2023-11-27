package com.cmsbackend.controller.course_controller.course_vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class UpdateCourseRequest {
    String Name;
    String Time;
    String Classroom;
    String Dept;
    String Description;
}
