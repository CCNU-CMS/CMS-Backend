package com.cmsbackend.controller.course_controller.course_vo;

import com.cmsbackend.entity.course_entity.Course;
import com.cmsbackend.entity.user_course_entity.UserCourse;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("获取某人选的课程")
public class CourseInfo {

    private Long id;
    private String name;
    private String time;
    private String classroom;
    private String dept;
    private String description;

    public CourseInfo(Long id, String name, String time, String classroom,
                    String dept, String description){
        this.id=id;
        this.name = name;
        this.time =time;
        this.classroom = classroom;
        this.dept = dept;
        this.description = description;
    }
}
