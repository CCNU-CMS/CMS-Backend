package com.cmsbackend.service.user_service.impl;

//import com.cms.cmsbackend.controller.user_controller.user_vo.UpdateInfoRequest;
import com.cmsbackend.dao.user_dao.UserDao;
import com.cmsbackend.entity.user_course_entity.UserCourse;
import com.cmsbackend.entity.user_entity.User;
import com.cmsbackend.service.user_service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;


    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;

    }

//    @Override
//    public User getUserById(Long id) {
//        return userDao.getById(id);
//    }

    public long save(User user){
         userDao.save(user);
         return user.getId();
    }


    public User getUserByAccount(String Account){
//        System.out.println("++++++++");
//        System.out.println();
        User user = userDao.findByAccount(Account);
//        System.out.println(user);
        return user;
    }


    public User getUserById(Long id){

        User user = userDao.findById(id);
        return user;
    }

    //通过邮箱获取身份
   public Long getIdentity(String Account){
        User user = userDao.findByAccount(Account);
        return user.getIdentity();
   }

    public void deleteUserByAccount(String account){
        userDao.deleteByAccount(account);
    }

    public List<User> getUserByIdentity(Integer Identity,Integer pageNum, Integer pageSize){
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        List<User>  user =  userDao.findAllByIdentity(Identity, pageable);
        return user;
    }

    public Page<User> getUser(Integer pageNum, Integer pageSize){
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        Page<User> user =  userDao.findAll(pageable);
        return user;
    }
//   public List<User> getInfo(Integer identity, Integer status,Integer pageNum,Integer pageSize){
//     Pageable pageable = PageRequest.of(pageNum,pageSize);
//     List<User> user = userDao.findAllByIdentityAndStatus(identity,status, pageable);
//     System.out.println(user);
//     return user;
//   }
}
