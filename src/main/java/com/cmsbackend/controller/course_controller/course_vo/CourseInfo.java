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
    private String academy;
    private String dept;
    private String description;
    private String teacher;


    public CourseInfo(Long id, String name, String time, String classroom,
                    String dept,String academy, String description,String teacher){
        this.id=id;
        this.name = name;
        this.time =time;
        this.classroom = classroom;
        this.academy = academy;
        this.dept = dept;
        this.description = description;
        this.teacher = teacher;
    }

}
