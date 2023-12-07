package com.cmsbackend.dao.course_dao;

import com.cmsbackend.entity.course_entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.io.Serializable;

public interface CourseDao extends JpaRepository<Course, Long>, Serializable {

    // 根据课程ID获取课程
    Course getById(Long id);

    // 根据课程名查找课程
    List<Course> findByName(String name);

    void deleteById(Long id);

    Page<Course> findAll(Pageable pageable);

    @Query("SELECT c FROM Course c WHERE c.id NOT IN :excludedCourseIds")
    Page<Course> findCoursesExcluding(@Param("excludedCourseIds") List<Long> excludedCourseIds, Pageable pageable);



}