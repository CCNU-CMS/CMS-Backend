package com.cmsbackend.service.course_service;

import com.cmsbackend.entity.course_entity.Course;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CourseService {
    long save(Course course);

    Course getCourseById(Long id);

    void deleteCourseById(long id);

    Page<Course> getCourseInfo(Integer pageNum, Integer pageSize);

    Page<Course> getCourseInfoExcludingSelected(int page, int size, List<Long> excludedCourseIds);

    }