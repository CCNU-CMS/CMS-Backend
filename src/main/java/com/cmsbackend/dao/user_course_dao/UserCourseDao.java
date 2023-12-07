package com.cmsbackend.dao.user_course_dao;

import com.cmsbackend.entity.user_entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cmsbackend.entity.user_course_entity.UserCourse;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.List;

public interface UserCourseDao extends JpaRepository<UserCourse,Integer>, Serializable {
    List<UserCourse>  findAllByUserId (long user_id, Pageable pageable);

    List<UserCourse>  findAllByCourseIdAndIdentity (long course_id, long identity, Pageable pageable);

    void deleteByCourseIdAndUserId(long course_id, long user_id);

    @Query("SELECT uc.courseId FROM UserCourse uc WHERE uc.userId = :userId")
    List<Long> findCourseIdsByUserId(@Param("userId") Long userId);
}

