package com.cmsbackend.service.user_course_service;

import com.cmsbackend.entity.user_course_entity.UserCourse;

import java.util.List;

public interface UserCourseService {
    List<UserCourse> getCourseIdByUserId(Long userId,  Integer pageNum, Integer pageSize);
    List<UserCourse> getUserIdByCourseIdAndIdentity(Integer CourseId,Integer identity,  Integer pageNum, Integer pageSize);

    UserCourse getCourseByCidAndUid(long cid,long uid);


    long save(UserCourse uc);
    void deleteUserCourseByCourseIdAndUserId(long cid,long uid);

//    List<Long> getCourseIdByUserId(long id);
//    List<UserCourse> getCourseIdByUserId(Long id);
      List<Long> getCourseIdByUserId(Long userId);

}
