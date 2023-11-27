package com.cmsbackend.dao.user_course_dao;

import com.cmsbackend.entity.user_entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cmsbackend.entity.user_course_entity.UserCourse;

import java.io.Serializable;
import java.util.List;

public interface UserCourseDao extends JpaRepository<UserCourse,Integer>, Serializable {
    List<UserCourse>  findAllByUserId (long user_id, Pageable pageable);
}

