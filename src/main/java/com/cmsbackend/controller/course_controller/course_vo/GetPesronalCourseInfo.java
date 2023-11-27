package com.cmsbackend.controller.course_controller.course_vo;

import com.cmsbackend.entity.course_entity.Course;
import com.cmsbackend.entity.user_course_entity.UserCourse;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("获取某人选的课程")
public class GetPesronalCourseInfo {

    private Course course;

    private UserCourse userCourse;

}
