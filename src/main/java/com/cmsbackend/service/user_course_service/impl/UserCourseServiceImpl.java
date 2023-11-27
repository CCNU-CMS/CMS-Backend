package com.cmsbackend.service.user_course_service.impl;

import com.cmsbackend.dao.user_course_dao.UserCourseDao;
import com.cmsbackend.entity.user_course_entity.UserCourse;
import com.cmsbackend.entity.user_entity.User;
import com.cmsbackend.service.user_course_service.UserCourseService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCourseServiceImpl implements UserCourseService {
    private final UserCourseDao userCourseDao;
    public UserCourseServiceImpl(UserCourseDao userCourseDao) {
        this.userCourseDao=userCourseDao;
    }

    public long save(UserCourse uc){
        userCourseDao.save(uc);
        return uc.getId();
    }
    public List<UserCourse> getCourseIdByUserId(Long userId,  Integer pageNum, Integer pageSize){
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        List<UserCourse>  userCourse =  userCourseDao.findAllByUserId(userId,pageable);
        return userCourse;
    }

}
