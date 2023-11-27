package com.cmsbackend.service.course_service;

import com.cmsbackend.entity.course_entity.Course;
import java.util.List;

public interface CourseService {
    long save(Course course);

    Course getCourseById(Long id);

    void deleteCourseById(long id);

//    List<Course> getCourseInfo(long user_id, Integer pageNum, Integer pageSize);

}