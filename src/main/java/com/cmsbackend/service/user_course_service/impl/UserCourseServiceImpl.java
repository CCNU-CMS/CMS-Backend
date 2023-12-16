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
    public List<UserCourse> getUserIdByCourseIdAndIdentity(Integer CourseId,Integer identity,  Integer pageNum, Integer pageSize){
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        List<UserCourse>  userCourse =  userCourseDao.findAllByCourseIdAndIdentity(CourseId,identity,pageable);
        return userCourse;
    }

    public void deleteUserCourseByCourseIdAndUserId(long cid, long uid){
        userCourseDao.deleteByCourseIdAndUserId(cid, uid);
    }
//    public  List<Long> getCourseIdByUserId(long id){
//        userCourseDao.
//    }
    public List<Long> getCourseIdByUserId(Long userId) {
        return userCourseDao.findCourseIdsByUserId(userId);
    }

    public UserCourse getCourseByCidAndUid(long cid, long uid){
        UserCourse uc = userCourseDao.getUserCourseByCourseIdAndAndUserId(cid, uid);
        return uc;
    }


}
