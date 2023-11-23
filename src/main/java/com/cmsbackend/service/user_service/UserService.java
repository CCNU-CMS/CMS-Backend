package com.cmsbackend.service.user_service;



import com.cmsbackend.entity.user_entity.User;

public interface UserService {
//    User getUserById(Long id);

    long save(User user);

    User getUserByAccount(String Account);

    int getIdentity(String Account);

//    List<User> getInfo(Integer identity, Integer status,Integer pageNum,Integer pageSize);

}
