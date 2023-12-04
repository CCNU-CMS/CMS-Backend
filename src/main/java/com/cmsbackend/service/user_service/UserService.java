package com.cmsbackend.service.user_service;

import com.cmsbackend.entity.user_course_entity.UserCourse;
import com.cmsbackend.entity.user_entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
//    User getUserById(Long id);

    long save(User user);

    User getUserByAccount(String Account);
    User getUserById(Long id);

    List<User> getUserByIdentity(Integer Identity,Integer pageNum, Integer pageSize);

    Page<User> getUser(Integer pageNum, Integer pageSize);

    Long getIdentity(String Account);

    void deleteUserByAccount(String account);

//    List<User> getInfo(Integer identity, Integer status,Integer pageNum,Integer pageSize);

}
