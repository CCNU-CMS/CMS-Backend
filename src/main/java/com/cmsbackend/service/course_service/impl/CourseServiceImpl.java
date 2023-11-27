package com.cmsbackend.service.course_service.impl;

import com.cmsbackend.dao.course_dao.CourseDao;
import com.cmsbackend.entity.course_entity.Course;
import com.cmsbackend.service.course_service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public long save(Course course) {
        Course savedCourse = courseDao.save(course);
        return savedCourse.getId();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseDao.getById(id);
    }

    @Override
    public void deleteCourseById (long id) {
         courseDao.deleteById(id);
    }


//    public List<Course> getCourseInfo(long supplier_id,Integer pageNum,Integer pageSize){
//        Pageable pageable = PageRequest.of(pageNum,pageSize);
//        List<Course> product = courseDao.findAllByUs(supplier_id,pageable);
//        System.out.println(product);
//        return product;
//    }

//    @Override
//    public List<Course> getCoursesByName(String name) {
//        return courseDao.findByName(name);
//    }

}