package com.cmsbackend.service.user_course_service;

import com.cmsbackend.entity.user_course_entity.UserCourse;

import java.util.List;

public interface UserCourseService {
    List<UserCourse> getCourseIdByUserId(Long userId,  Integer pageNum, Integer pageSize);

    long save(UserCourse uc);


//    List<UserCourse> getCourseIdByUserId(Long id);
}
