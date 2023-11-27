package com.cmsbackend.dao.course_dao;

import com.cmsbackend.entity.course_entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.io.Serializable;

public interface CourseDao extends JpaRepository<Course, Long>, Serializable {

    // 根据课程ID获取课程
    Course getById(Long id);

    // 根据课程名查找课程
    List<Course> findByName(String name);

    void deleteById(Long id);

    // 可以根据需要添加更多自定义查询方法
    // 例如根据课程描述模糊查询、根据教师ID查询课程等

}